package com.senai.Flora.Application.Services.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentClientDTO;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentClient;
import com.senai.Flora.Domain.Repositories.Relationships.EnviromentClientRepository;
import com.senai.Flora.Infrastructure.Mapper.Relationships.MapperEnviromentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnviromentClientService {

    @Autowired
    private EnviromentClientRepository repository;

    @Autowired
    private MapperEnviromentClient mapper;

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
            enviromentClient.getClientFlora().setIdClient(dto.id_Client());
            enviromentClient.getEnviroment().setIdEnviroment(dto.id_Enviroment());

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
