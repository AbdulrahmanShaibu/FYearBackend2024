package Project.Spring.Boot.Project.Model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Table
@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Component
public class JwtUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int id;
    public String firstName;
    public String lastName;

    @Column(unique = true)  // added 31/10/2023
    public String email;
    public String password;
//    private Role role;

    @Enumerated(EnumType.STRING)
    private Role role;


    private JwtUser jwtUser;
    public JwtUser(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

//    public void setRole(Role role) {
//        this.role = role;
//    }

    public JwtUser(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }


    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String firstname;
        private String lastname;
        private String email;
        private String password;

        public UserBuilder() {
        }
//        private Role role;

        public UserBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
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

//        public UserBuilder(Role role) {
//            this.role=role;
//            this.role = role;
//        }

        public JwtUser build() {
            JwtUser user = new JwtUser();
            user.setFirstName(this.firstname);
            user.setLastName(this.lastname);
            user.setEmail(this.email);
            user.setPassword(this.password);
//            user.setRole(this.role);
            return user;
        }
    }
}
