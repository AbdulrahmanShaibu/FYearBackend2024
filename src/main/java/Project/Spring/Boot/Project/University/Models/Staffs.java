package Project.Spring.Boot.Project.University.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staffs")
public class Staffs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long StaffID;

    public String StaffName;
    public String StaffEmail;
    public int StaffPhone;

    @ManyToOne
    @JsonIgnoreProperties("staffs") // Prevent recursion
    @JoinColumn(name = "client_site_id")
    private ClientSite clientSite;

    @OneToMany(mappedBy = "staffs")
    @JsonBackReference // Child side of the relationship
    private List<StaffComplain> staffComplaints;

    @OneToMany(mappedBy = "staffs")
    @JsonIgnoreProperties("staffs") // Prevent recursion
    private List<Attachment> attachments;

    public Staffs(Long staffId) {
    }
}
