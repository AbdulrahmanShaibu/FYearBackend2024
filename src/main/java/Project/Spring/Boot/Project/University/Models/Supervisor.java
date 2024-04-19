package Project.Spring.Boot.Project.University.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supervisorID;

//    @NonNull
    private String supervisorName;

//    @OneToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;

    @ManyToOne(cascade = CascadeType.PERSIST) //persist means that save() or persist() operations cascade to related entities
    @JoinColumn(name = "department_id")
    private Department department;

}
