package com.senai.Flora.Infrastructure.Config;

import com.senai.Flora.Domain.Repositories.Entity.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminBootstrap implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;



    @Value("${system.admin.email}")
    private String adminEmail;

    @Value("${system.admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) {

    }
}
