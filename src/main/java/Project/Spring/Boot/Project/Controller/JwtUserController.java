package Project.Spring.Boot.Project.Controller;

import Project.Spring.Boot.Project.SecurityServices.JwtUserService;
import Project.Spring.Boot.Project.Model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// JwtUserController.java
@RestController
@RequestMapping("/api/v1")
public class JwtUserController {

    private final JwtUserService userService;

    @Autowired
    public JwtUserController(JwtUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody JwtUser user) {
        JwtUser savedUser = userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }
}

