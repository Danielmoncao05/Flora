package com.senai.Flora.Application.Services.Entities;


import com.senai.Flora.Application.DTOs.Entities.ClientDTO;
import com.senai.Flora.Domain.Entities.Entity.ClientFlora;
import com.senai.Flora.Domain.Repositories.Entity.ClientRepository;
import com.senai.Flora.Infrastructure.Mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private Mapper mapper;

    public ClientDTO registerClient (ClientDTO dto) {
    ClientFlora clientFlora = mapper.toEntity(dto);
    ClientFlora save = repository.save(clientFlora);
    return mapper.toDTO(save);
    }

    public List<ClientDTO> listingClients () {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<ClientDTO> searchForId (Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public boolean updateClient (Long id , ClientDTO dto){
        return repository.findById(id).map(clientFlora -> {

            clientFlora.setName(dto.name());
            clientFlora.setAge(dto.age());
            clientFlora.setEmail(dto.email());

            repository.save(clientFlora);

            return true;

        }).orElse(false);
    }

    public boolean removeClient (Long id) {
        return repository.findById(id).map(clientFlora -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }
}
