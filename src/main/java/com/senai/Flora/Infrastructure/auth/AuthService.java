package com.senai.Flora.Infrastructure.auth;

import com.senai.Flora.Infrastructure.jwt.JwtUtil;
import com.senai.Flora.Infrastructure.repository.ClientRepository;
import com.senai.Flora.domain.ClientFlora;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final ClientRepository repository;
    private final JwtUtil jwtUtil;

    public String login(String email, String password){
        Optional<ClientFlora> client = repository.findByEmailAndPassword(email, password);
        if (client.isPresent()){
            return jwtUtil.generateToken(client.get().getEmail());

        }else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}
