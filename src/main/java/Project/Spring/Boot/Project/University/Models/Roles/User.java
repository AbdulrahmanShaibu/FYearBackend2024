package Project.Spring.Boot.Project.University.Models.Roles;
import Project.Spring.Boot.Project.University.Models.CleaningCompany;
import Project.Spring.Boot.Project.University.Models.ClientOrganisation;
import jakarta.persistence.*;

import java.util.List;

//This Entity is for  Company Staffs --> with roles CLEANER, ... implement login for them
@Entity
@Table(name = "company_roles")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private StaffRoles staffRoles;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private CleaningCompany cleaningCompany;

    @ManyToMany
    @JoinTable(
            name = "company_staff_client_organisation",
            joinColumns = @JoinColumn(name = "company_staff_id"),
            inverseJoinColumns = @JoinColumn(name = "client_organisation_id")
    )
    private List<ClientOrganisation> clientOrganisations;


    // Constructors, getters, setters
    public User() {
    }

    public User(String username, StaffRoles staffRoles) {
        this.username = username;
        this.staffRoles = staffRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public StaffRoles getRole() {
        return staffRoles;
    }

    public void setRole(StaffRoles staffRoles) {
        this.staffRoles = staffRoles;
    }

    public void setCleaningCompany(CleaningCompany cleaningCompany) {
        this.cleaningCompany = cleaningCompany;
    }

    public CleaningCompany getCleaningCompany() {
        return cleaningCompany;
    }

//    public void setClientOrganisations(List<ClientOrganisation> clientOrganisations) {
//        this.clientOrganisations = clientOrganisations;
//    }
//
//    public List<ClientOrganisation> getClientOrganisations() {
//        return clientOrganisations;
//    }
}
