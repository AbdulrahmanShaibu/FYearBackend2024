package Project.Spring.Boot.Project.SecurityServices;

import Project.Spring.Boot.Project.Model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// JwtUserDetailsService.java
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final JwtUserService userService;

    @Autowired
    public JwtUserDetailsService(JwtUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser user = userService.getUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
       return new User(user.getEmail(), user.getPassword(), new ArrayList<>());

        // Build UserDetails from JwtUser added 1/11/2023
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getEmail())
//                .password(user.getPassword())
//                // Add authorities/roles if applicable
//                .authorities(user.getAuthorities())
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
    }
}

