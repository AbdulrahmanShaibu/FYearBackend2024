//package Project.Spring.Boot.Project.University.Models.Roles;
//import Project.Spring.Boot.Project.University.Models.CleaningCompany;
//import Project.Spring.Boot.Project.University.Models.ClientOrganisation;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
////This Entity is for  Company Staffs --> with roles CLEANER, ... implement login for them
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "company_roles")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//
//    @ManyToMany
//    private List<StaffRoles> staffRoles;
//
//    @ManyToOne
//    @JoinColumn(name = "companyId")
//    private CleaningCompany cleaningCompany;
//
//    @ManyToMany
//    @JoinTable(
//            name = "company_staff_client_organisation",
//            joinColumns = @JoinColumn(name = "company_staff_id"),
//            inverseJoinColumns = @JoinColumn(name = "client_organisation_id")
//    )
//    private List<ClientOrganisation> clientOrganisations;
//
//
//    // Constructors, getters, setters
//
////    public void setClientOrganisations(List<ClientOrganisation> clientOrganisations) {
////        this.clientOrganisations = clientOrganisations;
////    }
////
////    public List<ClientOrganisation> getClientOrganisations() {
////        return clientOrganisations;
////    }
//}
