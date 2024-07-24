package Project.Spring.Boot.Project.University.Models.Roles;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "staff_roles")
public class StaffRoles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true)
    private RoleType roleName;

    // Default constructor
    public StaffRoles() {}

    // Parameterized constructor
    public StaffRoles(int id, RoleType roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleType getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleType roleName) {
        this.roleName = roleName;
    }
}
