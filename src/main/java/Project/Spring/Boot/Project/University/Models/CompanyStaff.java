package Project.Spring.Boot.Project.University.Models;

import Project.Spring.Boot.Project.University.Models.Roles.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private CleaningCompany cleaningCompany;

    @ElementCollection(targetClass = Roles.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "staff_roles")
    @Column(name = "role")
    private List<Roles> roles;

    @ManyToMany
    @JoinTable(
            name = "company_staff_client_organisation",
            joinColumns = @JoinColumn(name = "company_staff_id"),
            inverseJoinColumns = @JoinColumn(name = "client_organisation_id")
    )
    private List<ClientOrganisation> clientOrganisations;

}
