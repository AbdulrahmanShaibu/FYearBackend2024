//package Project.Spring.Boot.Project.University.Models.Roles;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//
//@Entity
//@Data
//@Table(name = "staff_roles")
//public class StaffRoles {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "role_name", nullable = false, unique = true)
//    private RoleType roleName;
//
//    // Default constructor
//    public StaffRoles() {}
//
//    @JsonCreator
//    public StaffRoles(@JsonProperty("roleName") String roleName) {
//        this.roleName = RoleType.valueOf(roleName.toUpperCase());
//    }
//
//    // Getters and setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public RoleType getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(RoleType roleName) {
//        this.roleName = roleName;
//    }
//}
