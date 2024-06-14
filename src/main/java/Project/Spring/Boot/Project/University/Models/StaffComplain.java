package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StaffComplain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int complainID;

    public String description;

    @Temporal(TemporalType.DATE)
    private Date submissionDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staffs staffs;

    @ManyToMany
    @JoinTable(
            name = "staff_complaint_claim_type",
            joinColumns = @JoinColumn(name = "staff_complaint_id"),
            inverseJoinColumns = @JoinColumn(name = "claim_type_id")
    )
    private List<ClaimType> claimTypes;

}
