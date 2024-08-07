package Project.Spring.Boot.Project.SecurityServices;

import Project.Spring.Boot.Project.Model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// JwtUserService.java
public interface JwtUserService {
    JwtUser saveUser(JwtUser user);
    JwtUser getUserByEmail(String email);
    List<JwtUser> getAllUsers();
}

