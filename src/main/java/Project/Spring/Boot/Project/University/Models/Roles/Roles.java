package Project.Spring.Boot.Project.University.Models.Roles;

public enum Roles {
    CLEANER("Cleaner"),
    MANAGER("Manager");
//    STUDENT("Student"),
//    TEACHER("Teacher");

    private final String roleName;

    Roles(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
