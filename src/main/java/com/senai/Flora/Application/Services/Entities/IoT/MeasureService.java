package com.senai.Flora.Application.Services.Entities.IoT;

import com.senai.Flora.Application.DTOs.Entities.IoT.MeasureDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Repositories.Entity.MeasureRepository;
import com.senai.Flora.Infrastructure.Mapper.Entities.IoT.MapperMeasure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeasureService {

    private final MeasureRepository repo;

    private final MapperMeasure mapper;

    public MeasureService(MeasureRepository repo, MapperMeasure mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public MeasureDTO registerMeasure (MeasureDTO dto) {
        Measure measure= mapper.toEntity(dto);
        repo.save(measure);
        return mapper.toDTO(measure);
    }

    public List<MeasureDTO> listMeasures () {
        return repo.findAll().stream().map(MapperMeasure::toDTO).collect(Collectors.toList());
    }

    public Optional<MeasureDTO> searchForId (Long id) {
        return repo.findById(id).map(MapperMeasure::toDTO);
    }

    public boolean updateMeasure (Long id , MeasureDTO dto) {
        return repo.findById(id).map(measure ->  {
            measure.setMeasure_name(dto.measure_name());
            measure.setMeasure_default(dto.measure_default());

            repo.save(measure);
            return true;

        }).orElse(false);
    }

    public boolean removeMeasure (Long id) {
        return repo.findById(id).map(measure -> {
            repo.deleteById(id);
            return true;

        }).orElse(false);
    }
}
