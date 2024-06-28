package Project.Spring.Boot.Project.University.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class CleaningCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyId;

    private String companyName;
    private String address;

    @OneToMany(mappedBy = "cleaningCompany")
    @JsonIgnoreProperties("cleaningCompany")
    private List<CompanyStaff> companyStaffs;
}
