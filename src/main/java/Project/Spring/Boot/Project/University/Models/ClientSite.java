package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClientSite {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;

 @ManyToOne
 @JoinColumn(name = "client_organisation_id")
 private ClientOrganisation clientOrganisation;

// @OneToMany(mappedBy = "clientSite")
// private List<Tool> tools;

 // @OneToMany(mappedBy = "clientSite")
// private List<Staffs> staffs;

}

