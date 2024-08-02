package Project.Spring.Boot.Project.University.Models;

//import Project.Spring.Boot.Project.University.Models.Roles.StaffRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

//This is CLEANER
public class CompanyStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companyId")
    private CleaningCompany cleaningCompany;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "staff_id")
//    private List<StaffRoles> roles;

    @ManyToMany
    @JoinTable(
            name = "company_staff_client_organisation",
            joinColumns = @JoinColumn(name = "company_staff_id"),
            inverseJoinColumns = @JoinColumn(name = "client_organisation_id")
    )
    private List<ClientOrganisation> clientOrganisations;
}
