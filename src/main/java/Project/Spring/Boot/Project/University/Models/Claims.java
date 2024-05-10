package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Claims {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int ClaimID;

    public String claimsDescription;
    public String ClaimType;
    //claims submitted by many staffs
    @OneToMany
    private List<Staff>staffs;

    //claims submitted by many cleaners
    @OneToMany
    private List<Cleaner>cleaners;

    @Temporal(TemporalType.DATE)
    private Date submissionDate;

    // Getter method to get staff names
    public List<String> getStaffNames() {
        if (staffs != null) {
            return staffs.stream()
                    .map(Staff::getStaffName)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    // Getter method to get cleaner names
    public List<String> getCleanerNames() {
        if (cleaners != null) {
            return cleaners.stream()
                    .map(Cleaner::getCleanerName)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

}
