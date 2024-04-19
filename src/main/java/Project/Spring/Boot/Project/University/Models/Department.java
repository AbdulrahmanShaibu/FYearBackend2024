package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
 public class Department {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long departmentID;

// @NonNull
 private String departmentName;

}

