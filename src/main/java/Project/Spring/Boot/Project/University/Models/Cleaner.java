package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Cleaner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int CleanerID;

    public String CleanerName;
    public String Gender;

    //many cleaners to one department
    @ManyToOne
    private Department department;

    //many cleaners to a tool
    @ManyToOne
    private Tool tool;

}
