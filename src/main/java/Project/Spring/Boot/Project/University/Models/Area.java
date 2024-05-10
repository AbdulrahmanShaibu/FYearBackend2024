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
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int areaID;

    public String areaName;
    public String location;

    // many area to one cleaner
    @ManyToOne
    private Cleaner cleaner;
}
