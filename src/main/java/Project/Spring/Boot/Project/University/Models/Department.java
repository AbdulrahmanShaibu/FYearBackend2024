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
 public class Department {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long departmentID;

 private String departmentName;

}

