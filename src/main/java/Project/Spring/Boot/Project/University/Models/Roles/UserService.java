//package Project.Spring.Boot.Project.University.Models.Roles;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
////    public User createUser(String username) {
////        User user = new User(username);
////        return userRepository.save(user);
////    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(Long id) {
//        return userRepository.findById(id);
//    }
//
////    public User updateUser(Long id, String username) {
////        Optional<User> userOptional = userRepository.findById(id);
////        if (userOptional.isPresent()) {
////            User user = userOptional.get();
////            user.setUsername(username);
////            user.setStaffRoles();
////            return userRepository.save(user);
////        }
////        return null;
////    }
//
//    public User updateUser(Long id, User user) {
//          Optional<User> userOptional = userRepository.findById(id);
//           if (userOptional.isPresent()) {
//             User existingUser = userOptional.get();
//             existingUser.setUsername(user.getUsername());
//             existingUser.setStaffRoles(user.getStaffRoles());
//             existingUser.setCleaningCompany(user.getCleaningCompany());
//             existingUser.setClientOrganisations(user.getClientOrganisations());
//             return userRepository.save(existingUser);
//           }
//           return (User) ResponseEntity.status(HttpStatus.BAD_REQUEST);
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//
//}
