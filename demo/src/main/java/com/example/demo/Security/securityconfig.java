// package com.example.demo.Security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class securityconfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(AbstractHttpConfigurer::disable)
//             .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                 .requestMatchers(
//                     "/", // Home page
//                      // Login page
//                     "/UOMmaster/**", // UOM master pages
//                     "/LocationMaster/**", // Location master pages
//                     "/ItemMaster",
//                     "/UserMaster",
//                     "/itemmaster/**", // Item master pages
//                     "/locationmaster/**",
//                     "/req/signup", // Signup request
//                     "/api/category-master/**",
//                     "/dashboard", // Dashboard
//                     "/items/**", // All requests under /items
//                     "/css/**", // Static CSS files
//                     "/js/**", // Static JS files
//                     "/images/**" // Static images
//                 )
//                 .permitAll()
//                 .anyRequest().authenticated()
//             )
//             .formLogin(formLogin -> formLogin
//                 .loginPage("/login")
//                 .permitAll()
//                 .defaultSuccessUrl("/dashboard", true)
//                 .failureUrl("/login?error") // Optional: Redirect to login with error if authentication fails
//             )
//             .logout(logout -> logout
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/login?logout") // Redirect to login after logout
//                 .invalidateHttpSession(true)
//                 .deleteCookies("JSESSIONID")
//             );

//         return http.build();
//     }
// }
package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .anyRequest().permitAll() // Permit all requests without authentication
            );
            // .formLogin(formLogin -> formLogin
            //     .loginPage("/login")
            //     .permitAll()
            //     .defaultSuccessUrl("/dashboard", true)
            //     .failureUrl("/login?error") // Optional: Redirect to login with error if authentication fails
            // )
            // .logout(logout -> logout
            //     .logoutUrl("/logout")
            //     .logoutSuccessUrl("/login?logout") // Redirect to login after logout
            //     .invalidateHttpSession(true)
            //     .deleteCookies("JSESSIONID")
                // );

            return http.build();
        }
    }
