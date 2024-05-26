package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int StaffID;

    public String StaffName;
    public String StaffEmail;
    public int StaffPhone;

}

