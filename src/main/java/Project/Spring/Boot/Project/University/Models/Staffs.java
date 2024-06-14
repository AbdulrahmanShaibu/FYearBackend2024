package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int StaffID;

    public String StaffName;
    public String StaffEmail;
    public int StaffPhone;

    @ManyToOne
    @JoinColumn(name = "client_site_id")
    private ClientSite clientSite;

    @OneToMany(mappedBy = "staffs")
    private List<StaffComplain> staffComplaints;

    @OneToMany(mappedBy = "staffs")
    private List<Attachment> attachments;

}

