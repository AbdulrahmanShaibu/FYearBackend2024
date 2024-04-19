package Project.Spring.Boot.Project.SecurityServices;

import Project.Spring.Boot.Project.Model.JwtUser;
import Project.Spring.Boot.Project.Repository.JwtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// JwtUserServiceImpl.java
@Service
public class JwtUserServiceImpl implements JwtUserService {

    private final JwtRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public JwtUserServiceImpl(JwtRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JwtUser saveUser(JwtUser user) {
        // Hash the user's password before saving it
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public JwtUser getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<JwtUser> getAllUsers() {
        return userRepository.findAll();
    }
}

