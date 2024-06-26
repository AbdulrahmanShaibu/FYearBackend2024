package Project.Spring.Boot.Project.University.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toolID;

    @NonNull
    private String toolType;

    @NonNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_site_id")
    private ClientSite clientSite;

}
