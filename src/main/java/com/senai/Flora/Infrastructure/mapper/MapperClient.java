package com.senai.Flora.Infrastructure.mapper;

import com.senai.Flora.Infrastructure.dto.ClientDTO;
import com.senai.Flora.domain.ClientFlora;
import org.springframework.stereotype.Component;

@Component
public class MapperClient {

    public ClientFlora toEntity (ClientDTO dto) {
        if (dto == null) return null;
        ClientFlora clientFlora = new ClientFlora();
        clientFlora.setName(dto.name());
        clientFlora.setAge(dto.age());
        clientFlora.setEmail(dto.email());

        return clientFlora;
    }

    public ClientDTO toDTO (ClientFlora client) {
        if (client == null) return null;
        return new ClientDTO(
                client.getIdClient(),
                client.getName(),
                client.getAge(),
                client.getEmail()
        );
    }
}
