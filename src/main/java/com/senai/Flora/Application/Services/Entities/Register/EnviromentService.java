package com.senai.Flora.Application.Services.Entities.Register;

import com.senai.Flora.Application.DTOs.Entities.Register.EnviromentDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Enviroment;
import com.senai.Flora.Domain.Repositories.Entity.EnviromentRepository;
import com.senai.Flora.Infrastructure.Mapper.MapperEnviroment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnviromentService {

    @Autowired
    private EnviromentRepository repo;

    @Autowired
    private MapperEnviroment mapper;

    public EnviromentDTO registerEnviroment (EnviromentDTO dto) {
        Enviroment enviroment = mapper.toEntity(dto);
        repo.save(enviroment);
        return mapper.toDTO(enviroment);
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
            enviroment.setLocation(LocalDateTime.now());

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
}
