package Project.Spring.Boot.Project.SpringSecurity;

import Project.Spring.Boot.Project.University.Models.Admin;
import Project.Spring.Boot.Project.UniversityRepository.AdminRepository;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final SecurityFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
//                .requestMatchers("/api/v1/auth/authenticate").permitAll()
                .requestMatchers("/api/v1/**").permitAll()
                .requestMatchers("/api/v1/admin/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }



    //Added 15/04/2024
//    @Autowired
//    private AdminRepository adminRepository;
//    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> {
//            Admin admin = adminRepository.findByUsername(username)
//                    .orElseThrow(() -> new UsernameNotFoundException("Admin User not found"));
//            return User
//                    .withUsername(admin.getUserName())
//                    .password(String.valueOf(admin.getPassword()))
//                    .roles("ADMIN")
//                    .build();
//        });
//    }

}
