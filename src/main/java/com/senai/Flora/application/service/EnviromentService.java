package com.senai.Flora.application.service;

import com.senai.Flora.Infrastructure.dto.EnviromentDTO;
import com.senai.Flora.Infrastructure.repository.ClientRepository;
import com.senai.Flora.domain.ClientFlora;
import com.senai.Flora.domain.Enviroment;
import com.senai.Flora.Infrastructure.repository.EnviromentRepository;
import com.senai.Flora.Infrastructure.mapper.MapperEnviroment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // * coloquei pra n ter que usar o @Autowired blz
public class EnviromentService {

    private final EnviromentRepository repo;

    private final MapperEnviroment mapper;

    private final ClientRepository clientRepository; // * pra buscar o dono do ambiente

//    public EnviromentDTO registerEnviroment (EnviromentDTO dto) {
//        Enviroment enviroment = mapper.toEntity(dto);
//        repo.save(enviroment);
//        return mapper.toDTO(enviroment);
//    }

    public EnviromentDTO registerEnviroment(EnviromentDTO dto){
        ClientFlora owner = null;
        if (dto.ownerId() != null){ // * pra buscar o dono que é o usuario com base no Id que vai vir do front
            owner = clientRepository.findById(dto.ownerId()).orElse(null);
        }

        Enviroment enviroment = mapper.toEntity(dto, owner);
        repo.save(enviroment);

        return mapper.toDTO(enviroment);
    }

    public EnviromentDTO createEnviroment(EnviromentDTO dto){
        Long onwerId = dto.ownerId();
        ClientFlora owner = clientRepository.findById(onwerId).orElse(null);
        Enviroment env = mapper.toEntity(dto, owner);
        Enviroment saved = repo.save(env);
        return mapper.toDTO(saved);
    }


    public List<EnviromentDTO> listEnviroments () {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<EnviromentDTO> searchForId (Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public boolean updateEnviroment (Long id , EnviromentDTO dto) {
        return repo.findById(id).map(enviroment -> {
            enviroment.setNameDescription(dto.nameDescription());
            enviroment.setObservation(dto.observation());
            enviroment.setState(dto.state());
            enviroment.setLocation(dto.location());

            repo.save(enviroment);

            return true;
        }).orElse(false);
    }

    public boolean removeEnviroment(Long id) {
        return repo.findById(id).map(enviroment -> {
            repo.deleteById(id);

            return true;

        }).orElse(false);
    }

    // * funcao pra retornar todos os ambientes de um certo usuario, igual oq eu fiz naquele outro repositorio meu que te mostrei, mas esse usa o mapper ao inves do DTO

    public List<EnviromentDTO> getEnvironmentsByUserId(Long userId){
        return repo.findByOwner_IdClient(userId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    //---------------------------------------------------------------
}
