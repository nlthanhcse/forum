package ojt.thanhnl4.forumapigateway.service;

import ojt.thanhnl4.forumapigateway.model.User;
import ojt.thanhnl4.forumapigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userFromDB = this.userRepository.findByUsername(s);
        System.out.println(userFromDB);
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (userFromDB == null) {
            throw new UsernameNotFoundException("Username does not exist.");
        }
        grantedAuthorities.add(new SimpleGrantedAuthority(this.getRoleByUsername(userFromDB.getUsername())));
        return new org.springframework.security.core.userdetails.User(
                userFromDB.getUsername(),
                userFromDB.getPassword(),
                grantedAuthorities
        );
    }

    public String getRoleByUsername(String username) {
        return this.userRepository.getRoleByUsername(username);
    }
}
