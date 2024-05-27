package Project.Spring.Boot.Project.Controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody RegisterRequest request){
           return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>SignAuthenticateUser(@RequestBody AuthenticattionRequest request){
        // Log the request details for debugging
        logger.debug("Register request received: {}", request);
        return ResponseEntity.ok(service.authenticate(request));
    }
}
