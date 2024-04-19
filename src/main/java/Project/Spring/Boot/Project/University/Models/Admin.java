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
@Table
public class Admin {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public int AdminId;

    @NonNull
    public String UserName;

    @NonNull
    public String Email;

    @NonNull
    public int Phone;

    @NonNull
    public int Password;
}
