package com.senai.Flora.Application.Services.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentClientDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentClient;
import com.senai.Flora.Domain.Repositories.Relationships.EnviromentClientRepository;
import com.senai.Flora.Infrastructure.Mapper.Relationships.MapperEnviromentClient;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnviromentClientService {

    @Autowired
    private EnviromentClientRepository repository;

    @Autowired
    private MapperEnviromentClient mapper;

    private final EntityManager entityManager;

    public EnviromentClientService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EnviromentClientDTO registerRelation (EnviromentClientDTO dto) {
        EnviromentClient enviromentClient = mapper.toEntity(dto);
        EnviromentClient save = repository.save(enviromentClient);

        return mapper.toDTO(save    );
    }

    public List<EnviromentClientDTO> listEnviromentClient () {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<EnviromentClientDTO> searchForId (Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public boolean updateEnviromentClient (Long id , EnviromentClientDTO dto) {
        return repository.findById(id).map(enviromentClient ->  {
            // Take the reference of Client flora and assign
            enviromentClient.setClientFlora(entityManager.getReference(ClientFlora.class, dto.idClient()));

            // Take the reference of Enviroment and assign
            enviromentClient.setEnviroment(entityManager.getReference(Enviroment.class, dto.idEnviroment()));

            enviromentClient.setAttributionDate(LocalDate.now());

            repository.save(enviromentClient);
            return true;

        }).orElse(false);
    }

    public boolean removeEnviromentClient (Long id) {
        return repository.findById(id).map(enviromentClient ->  {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }


}
