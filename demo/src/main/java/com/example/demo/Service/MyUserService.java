// package com.example.demo.Service;

// import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.example.demo.Entity.MyappUser;
// import com.example.demo.Model.MyappUserRepo;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class MyUserService implements UserDetailsService {

//     private static final Logger logger = LoggerFactory.getLogger(MyUserService.class);

//     @Autowired
//     private MyappUserRepo repository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Optional<MyappUser> user = repository.findByUsername(username);
//         if (user.isPresent()) {
//             MyappUser userObj = user.get();
//             String dbUsername = userObj.getUsername();
//             String dbPassword = userObj.getPassword();

//             if (dbUsername == null || dbUsername.isEmpty() || dbPassword == null || dbPassword.isEmpty()) {
//                 logger.error("Invalid user data: username or password is null/empty. User: {}", userObj);
//                 throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
//             }

//             return User.builder()
//                 .username(dbUsername)
//                 .password(dbPassword)
//                 .authorities("USER") // You can add authorities or roles as needed
//                 .build();
//         } else {
//             logger.error("User not found: {}", username);
//             throw new UsernameNotFoundException("User not found: " + username);
//         }
//     }
// }
