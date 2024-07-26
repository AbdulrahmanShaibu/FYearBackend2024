//package Project.Spring.Boot.Project.University.Models.Roles;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api/v1")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    RoleTypeRepository roleTypeRepository;
//
//    @PostMapping("/create/users")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
//
//    @GetMapping("/list/users")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
//    @GetMapping("/list/roles")
//    public List<StaffRoles> listRoles() {
//        return roleTypeRepository.findAll();
//    }
//
//    @GetMapping("/get/user/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        Optional<User> user = userService.getUserById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/update/user/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        User updatedUser = userService.updateUser(id, user);
//        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/delete/user/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
//}
