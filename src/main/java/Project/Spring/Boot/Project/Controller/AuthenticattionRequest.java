package Project.Spring.Boot.Project.Controller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authentications")
public class AuthenticattionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String email;
    public String password;

}
