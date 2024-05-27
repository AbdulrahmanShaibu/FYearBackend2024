package Project.Spring.Boot.Project.Controller;

import Project.Spring.Boot.Project.Model.JwtUser;
import Project.Spring.Boot.Project.Model.JwtUtil;
import Project.Spring.Boot.Project.Model.Role;
import Project.Spring.Boot.Project.Repository.JwtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
import java.util.Optional;

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
        System.out.println("generated token for registered user:"+user.getUsername()+" "+"is:"+" "+jwtToken); //printing token
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


//    This is signIn logic after user Registration for registered users
public AuthenticationResponse authenticate(AuthenticattionRequest request) {
    try {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication); // Ensure the context is set

        JwtUser user= jwtRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + request.getEmail());
        }

        String jwtToken = jwtUtil.generateToken(user);
        System.out.println("generated token for authenticated user:"+user.getUsername()+" "+jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    } catch (BadCredentialsException authenticationException) {
        authenticationException.printStackTrace();
        throw new RuntimeException("Sorry, authentication failed: Invalid credentials");
    }
}


}
