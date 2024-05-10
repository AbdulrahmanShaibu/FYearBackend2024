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
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int TaskID;

    public String Description;

    //one task to many cleaners(required concept)...
    @OneToMany
    private List<Cleaner>cleaners;


    //implemented for testing but required concept is above
//    @ManyToOne
//    private Cleaner cleaners;

}
