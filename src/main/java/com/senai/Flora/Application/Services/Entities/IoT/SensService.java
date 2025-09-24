package com.senai.Flora.Application.Services.Entities.IoT;

import com.senai.Flora.Application.DTOs.Entities.IoT.SensDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Repositories.Entity.SensRepository;
import com.senai.Flora.Infrastructure.Mapper.MapperSens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SensService {

    @Autowired
    private SensRepository repo;

    @Autowired
    private MapperSens mapper;

    public SensDTO registerSens (SensDTO dto) {
        Sens sens = mapper.toEntity(dto);
        repo.save(sens);
        return mapper.toDTO(sens);
    }

    public List<SensDTO> listSens () {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<SensDTO> searchForId (Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public boolean updateSens(Long id , SensDTO dto) {
        return repo.findById(id).map(sens ->  {
            sens.setType(dto.type());
            sens.setValue_sens(dto.value_sens());
            sens.setSens_name(dto.sens_name());
            sens.setAttribution_date(LocalDateTime.now());

            repo.save(sens);

            return true;
        }).orElse(false);
    }

    public boolean removeSens (Long id) {
        return repo.findById(id).map(sens -> {
            repo.deleteById(id);
            return true;

        }).orElse(false);
    }
}
