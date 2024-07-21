package Project.Spring.Boot.Project.University.Models;


import Project.Spring.Boot.Project.Model.JwtUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;

    @Lob
    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @ManyToOne
    @JsonBackReference // Use this annotation to handle the relationship
    @JoinColumn(name = "staff_id")
    private JwtUser staffs;  // should be jwt user, renamed from Staffs to jwt user

    //for solving an infinite recursive call which exhausts the stack space.

}
