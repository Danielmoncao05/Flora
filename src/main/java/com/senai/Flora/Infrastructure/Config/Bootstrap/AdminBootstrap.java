package com.senai.Flora.Infrastructure.Config.Bootstrap;

import com.senai.Flora.Domain.Entities.Entity.Abstract.User;
import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;
import com.senai.Flora.Domain.Entities.Enum.Role;
import com.senai.Flora.Domain.Repositories.Entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Value("${system.admin.email}")
    private String adminEmail;

    @Value("${system.admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) {

        if (userRepository.findByEmail(adminEmail).isEmpty()) {
            User admin = new ClientFlora();
            admin.setName("Admin");
            admin.setAge(0);
            admin.setEmail(adminEmail);
            admin.setPassword(passwordEncoder.encode(adminPassword));
            admin.setStatus(true);
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);
        }
//            userRepository.findByEmail(adminEmail).ifPresentOrElse(
//                    user -> userRepository.save(user),
//                    () -> {
//
//                    }
//            );
    }
}
