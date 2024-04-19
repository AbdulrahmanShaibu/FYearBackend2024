package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Admin;
import Project.Spring.Boot.Project.UniversityRepository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity<String> createAdmin(Admin admin) {
        // Retrieve the admin by ID from the database
        Optional<Admin> existingAdmin = adminRepository.findById(admin.getAdminId());

        if (!existingAdmin.isPresent()) {
            // Return a 404 status code if the admin ID is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Admin ID not found.");
        }

        // Retrieve the existing admin
        Admin existing = existingAdmin.get();

        // Verify the password
        if (existing.getPassword()!=(admin.getPassword())) {
            // Return a 401 status code if the password does not match
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Incorrect password.");
        }

        // Successful login
        return ResponseEntity.status(HttpStatus.OK)
                .body("Login successful!");
    }

}
