package Project.Spring.Boot.Project.Model;

import Project.Spring.Boot.Project.University.Models.Attachment;
import Project.Spring.Boot.Project.University.Models.ClientSite;
import Project.Spring.Boot.Project.University.Models.StaffComplain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
@Component
public class JwtUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JsonIgnoreProperties("staffs")
    @JoinColumn(name = "client_site_id")
    private ClientSite clientSite;

    @OneToMany(mappedBy = "staffs")
    @JsonBackReference
    private List<StaffComplain> staffComplaints;

    @OneToMany(mappedBy = "staffs")
    @JsonIgnoreProperties("staffs")
    private List<Attachment> attachments;

    public JwtUser(int id, String firstName, String lastName, String email, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role userRole = getRole();
        if (userRole != null) {
            return List.of(new SimpleGrantedAuthority(userRole.name()));
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Role role;

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public JwtUser build() {
            return new JwtUser(0, firstName, lastName, email, password, role);
        }
    }
}
