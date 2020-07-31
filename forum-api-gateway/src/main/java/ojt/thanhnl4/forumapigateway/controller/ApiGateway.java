package ojt.thanhnl4.forumapigateway.controller;

import ojt.thanhnl4.forumapigateway.model.*;
import ojt.thanhnl4.forumapigateway.service.CustomUserDetailService;
import ojt.thanhnl4.forumapigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiGateway {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUserDetailService userDetailService;

    @GetMapping("/users/")
    public List<User> getAllUser() {
        return this.restTemplate.exchange(
                "http://user-service/users/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }).getBody();
    }

    @GetMapping("/users/user/{user_id}")
    public User getUser(@PathVariable(name = "user_id") Integer user_id) {
        return this.restTemplate.exchange(
                "http://user-service/users/user/" + user_id,
                HttpMethod.GET,
                null,
                User.class
        ).getBody();
    }

    @GetMapping("/users/user/username/{username}")
    public User getUserByUsername(@PathVariable(name = "username") String username, HttpServletRequest httpServletRequest) {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String currentUsername = jwtUtil.extractUsername(authorizationHeader.substring(7));
        System.out.println(this.userDetailService.getRoleByUsername(username));
        if (!currentUsername.equals(username) && this.userDetailService.getRoleByUsername(currentUsername).equals("ROLE_USER")) {
            throw new AccessDeniedException("Access denied");
        }
        return this.restTemplate.exchange(
                "http://user-service/users/user/username/" + username,
                HttpMethod.GET,
                null,
                User.class
        ).getBody();
    }

    @PostMapping("/users/user")
    public User addUser(@RequestBody User user) {
        return this.restTemplate
                .postForObject(
                        "http://user-service/users/user",
                        user,
                        User.class
                );
    }

    @DeleteMapping("/users/user/{user_id}")
    public User deleteUser(@PathVariable(name = "user_id") Integer user_id) {
        User userDeleted = this.restTemplate.exchange(
                "http://user-service/users/user/" + user_id,
                HttpMethod.GET,
                null,
                User.class
        ).getBody();
        this.restTemplate.exchange(
                "http://user-service/users/user/" + user_id,
                HttpMethod.DELETE,
                null,
                User.class
        );
        return userDeleted;
    }

    @GetMapping("/categories/")
    public List<Category> getAllCategory() {
        return this.restTemplate.exchange(
                "http://category-service/categories/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Category>>() {
                }
        ).getBody();
    }

    @GetMapping("/categories/category/{category_id}")
    public Category getCategory(@PathVariable(name = "category_id") Integer category_id) {
        return this.restTemplate.exchange(
                "http://category-service/categories/category/" + category_id,
                HttpMethod.GET,
                null,
                Category.class
        ).getBody();
    }

    @PostMapping("/categories/category")
    public Category addCategory(@RequestBody Category category) {
        return this.restTemplate
                .postForObject(
                        "http://category-service/categories/category",
                        category,
                        Category.class
                );
    }

    @DeleteMapping("/categories/category/{category_id}")
    public Category deleteCategory(@PathVariable(name = "category_id") Integer category_id) {
        return this.restTemplate.exchange(
                "http://category-service/categories/category/" + category_id,
                HttpMethod.DELETE,
                null,
                Category.class
        ).getBody();
    }

    @GetMapping("/posts/")
    public List<Post> getAllPost() {
//        System.out.println(1111);
        return this.restTemplate.exchange(
                "http://post-service/posts/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {
                }
        ).getBody();
    }

    @GetMapping("/posts/user/{user_id}")
    public List<Post> getAllPostByUserId(@PathVariable(name = "user_id") Integer user_id) {
        return this.restTemplate.exchange(
                "http://post-service/posts/user/" + user_id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {
                }
        ).getBody();
    }

    @GetMapping("/posts/category/{category_id}")
    public List<Post> getAllPostByCategoryId(@PathVariable(name = "category_id") Integer category_id) {
        return this.restTemplate.exchange(
                "http://post-service/posts/category/" + category_id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {
                }
        ).getBody();
    }

    @GetMapping("/posts/post/{post_id}")
    public Post getPost(@PathVariable(name = "post_id") Integer post_id) {
        return this.restTemplate.exchange(
                "http://post-service/posts/post/" + post_id,
                HttpMethod.GET,
                null,
                Post.class
        ).getBody();
    }

    @PostMapping("/posts/post")
    public Post addPost(@RequestBody Post post) {
        return this.restTemplate
                .postForObject(
                        "http://post-service/posts/post",
                        post,
                        Post.class
                );
    }

    @DeleteMapping("/posts/post/{post_id}")
    public Post deletePost(@PathVariable(name = "post_id") Integer post_id) {
        return this.restTemplate.exchange(
                "http://post-service/posts/post/" + post_id,
                HttpMethod.DELETE,
                null,
                Post.class
        ).getBody();
    }

    @GetMapping("/comments/")
    public List<Comment> getAllComment() {
        return this.restTemplate.exchange(
                "http://comment-service/comments/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Comment>>() {
                }
        ).getBody();
    }

    @GetMapping("/comments/post/{post_id}")
    public List<Comment> getAllCommentByPostId(@PathVariable(name = "post_id") Integer post_id) {
        return this.restTemplate.exchange(
                "http://comment-service/comments/post/" + post_id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Comment>>() {
                }
        ).getBody();
    }

    @GetMapping("/comments/comment/{comment_id}")
    public Comment getComment(@PathVariable(name = "comment_id") Integer comment_id) {
        return this.restTemplate.exchange(
                "http://comment-service/comments/comment/" + comment_id,
                HttpMethod.GET,
                null,
                Comment.class
        ).getBody();
    }

    @PostMapping("/comments/comment")
    public Comment addComment(@RequestBody Comment comment) {
        return this.restTemplate
                .postForObject(
                        "http://comment-service/comments/comment",
                        comment,
                        Comment.class
                );
    }

    @DeleteMapping("/comments/comment/{comment_id}")
    public Comment deleteComment(@PathVariable(name = "comment_id") Integer comment_id) {
        return this.restTemplate.exchange(
                "http://comment-service/comments/comment/" + comment_id,
                HttpMethod.DELETE,
                null,
                Comment.class
        ).getBody();
    }

    @GetMapping("/user-posts/{user_id}/{type}")
    public List<UserPost> getLikedOrUnlikedUserPostsByUserIdAndType(@PathVariable(name = "user_id") Integer user_id,
                                                                    @PathVariable(name = "type") String type) {
        return this.restTemplate.exchange(
                "http://user-post-service/user-posts/" + user_id + "/" + type,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserPost>>() {
                }
        ).getBody();
    }

    @GetMapping("/user-posts/user-post/{user_id}/{post_id}")
    public UserPost getUserPost(@PathVariable(name = "user_id") Integer user_id,
                                @PathVariable(name = "post_id") Integer post_id) {
        return this.restTemplate.exchange(
                "http://user-post-service/user-posts/user-post/" + user_id + "/" + post_id,
                HttpMethod.GET,
                null,
                UserPost.class
        ).getBody();
    }

    @DeleteMapping("/user-posts/user-post/{user_id}/{post_id}")
    public UserPost deleteUserPostByUserIdAndPostId(@PathVariable(name = "user_id") Integer user_id,
                                                    @PathVariable(name = "post_id") Integer post_id) {
        return this.restTemplate.exchange(
                "http://user-post-service/user-posts/user-post/" + user_id + "/" + post_id,
                HttpMethod.DELETE,
                null,
                UserPost.class
        ).getBody();
    }

    @GetMapping("/user-comments/{user_id}/{type}")
    public List<UserComment> getLikedOrUnlikedUserCommentByUserIdAndType(@PathVariable(name = "user_id") Integer user_id,
                                                                         @PathVariable(name = "type") String type) {
        return this.restTemplate.exchange(
                "http://user-comment-service/user-comments/" + user_id + "/" + type,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserComment>>() {
                }
        ).getBody();
    }

    @GetMapping("/user-comments/user-comment/{user_id}/{comment_id}")
    public UserComment getUserComment(@PathVariable(name = "user_id") Integer user_id,
                                      @PathVariable(name = "comment_id") Integer comment_id) {
        return this.restTemplate.exchange(
                "http://user-comment-service/user-comments/user-comment/" + user_id + "/" + comment_id,
                HttpMethod.GET,
                null,
                UserComment.class
        ).getBody();
    }

    @DeleteMapping("/user-comments/user-comment/{user_id}/{comment_id}")
    public UserComment deleteUserCommentByUserIdAndPostId(@PathVariable(name = "user_id") Integer user_id,
                                                          @PathVariable(name = "comment_id") Integer comment_id) {
        return this.restTemplate.exchange(
                "http://user-comment-service/user-comments/user-comment/" + user_id + "/" + comment_id,
                HttpMethod.DELETE,
                null,
                UserComment.class
        ).getBody();
    }

    @PostMapping("/auth/sign-up")
    public AuthResponse signUp(@RequestBody User user) {
        return this.restTemplate
                .postForObject(
                        "http://login-service/auth/sign-up",
                        user,
                        AuthResponse.class
                );
    }

    @PostMapping("/auth/sign-in")
    public AuthResponse signIn(@RequestBody User user) {
        HttpEntity<User> userPassed = new HttpEntity<>(user);
        return this.restTemplate
                .postForObject(
                        "http://login-service/auth/sign-in",
                        userPassed,
                        AuthResponse.class
                );
    }

    @GetMapping("/auth/sign-out")
    public AuthResponse signOut() {
        return this.restTemplate.exchange(
                "http://login-service/auth/sign-out",
                HttpMethod.GET,
                null,
                AuthResponse.class
        ).getBody();
    }

    @PostMapping("/auth/log-in")
    public String getJwtToken(@RequestBody User user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Username or password is incorrect.");
        }
        return jwtUtil.generateToken(user.getUsername());
    }
}
