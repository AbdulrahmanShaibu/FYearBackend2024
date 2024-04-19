package Project.Spring.Boot.Project.Controller;

import Project.Spring.Boot.Project.Model.JwtUser;
import Project.Spring.Boot.Project.Model.JwtUtil;
import Project.Spring.Boot.Project.Model.Role;
import Project.Spring.Boot.Project.Repository.JwtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private final JwtRepository jwtRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtUtil jwtUtil;
    @Autowired
    private final JwtUser jwtUser;
    //private final RegisterRequest request;


    //Authenticate User during Registration
    public AuthenticationResponse register(RegisterRequest request) {
        var user = jwtUser.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.USER)
                .build();
        jwtRepository.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


//    This is sigin In logic after user Registration for registered users
    public AuthenticationResponse authenticate(AuthenticattionRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            // Fetch all users with the provided email
            var users = jwtRepository.findByEmail(request.getEmail());
            var jwtToken = jwtUtil.generateToken(users);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        } catch (AuthenticationException authenticationException) {
            // Log the authentication failure
            authenticationException.printStackTrace();
            throw new RuntimeException("Sorry, authentication failed: " + authenticationException.getMessage());
        }
    }

}
