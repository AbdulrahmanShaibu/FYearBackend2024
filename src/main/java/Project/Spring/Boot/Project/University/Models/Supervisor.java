package Project.Spring.Boot.Project.University.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supervisorID;

    private String supervisorName;

    // supervisor manages many departments
    @OneToMany(fetch = FetchType.EAGER)
    private List<Department> department;

}
