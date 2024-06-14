package Project.Spring.Boot.Project.University.Models.Roles;
import Project.Spring.Boot.Project.University.Models.CleaningCompany;
import Project.Spring.Boot.Project.University.Models.ClientOrganisation;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company_roles")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private Roles roles;

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

    public User(String username, Roles roles) {
        this.username = username;
        this.roles = roles;
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

    public Roles getRole() {
        return roles;
    }

    public void setRole(Roles roles) {
        this.roles = roles;
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
