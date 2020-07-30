package ojt.thanhnl4.loginservice.controller;

import ojt.thanhnl4.loginservice.model.AuthResponse;
import ojt.thanhnl4.loginservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/sign-up")
    public AuthResponse signUp(@RequestBody User user) {
        AuthResponse<User> authResponse = new AuthResponse();
        User userFromDB = this.restTemplate.exchange(
                "http://user-service/users/user/username/" + user.getUsername(),
                HttpMethod.GET,
                null,
                User.class
        ).getBody();
        if (userFromDB != null) {
            authResponse.setError_code(401);
            authResponse.setError_message("User have been used.");
            authResponse.setResponse_object(null);
        } else {
            authResponse.setResponse_object(
                    this.restTemplate
                            .postForObject(
                                    "http://user-service/users/user",
                                    user,
                                    User.class
                            )
            );
            authResponse.setError_code(200);
            authResponse.setError_message("Sign up successfully.");
        }
        return authResponse;
    }

    @GetMapping("/sign-in")
    public AuthResponse signIn(@RequestBody User user, HttpSession httpSession) {
        AuthResponse<User> authResponse = new AuthResponse();
        User userFromDB = this.restTemplate.exchange(
                "http://user-service/users/user/username/" + user.getUsername(),
                HttpMethod.GET,
                null,
                User.class
        ).getBody();
        if (userFromDB != null) {
            if (user.getPassword().equals(userFromDB.getPassword())) {
                authResponse.setError_code(200);
                authResponse.setError_message("Sign in successfully.");
                authResponse.setResponse_object(user);
                httpSession.setAttribute("user", userFromDB);
            } else {
                authResponse.setError_code(401);
                authResponse.setError_message("Password is incorrect.");
                authResponse.setResponse_object(null);
            }
        } else {
            authResponse.setError_code(401);
            authResponse.setError_message("User does not exist.");
            authResponse.setResponse_object(null);
        }
        return authResponse;
    }

    @GetMapping("/sign-out")
    public AuthResponse signOut(HttpSession httpSession) {
        AuthResponse authResponse = new AuthResponse("Sign out successfully.", 200, null);
        httpSession.invalidate();
        return authResponse;
    }
}
