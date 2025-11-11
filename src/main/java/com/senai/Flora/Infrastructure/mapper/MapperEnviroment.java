package com.senai.Flora.Infrastructure.mapper;

import com.senai.Flora.Infrastructure.dto.EnviromentDTO;
import com.senai.Flora.domain.ClientFlora;
import com.senai.Flora.domain.Enviroment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MapperEnviroment {


    public Enviroment toEntity(EnviromentDTO dto, ClientFlora owner){  // * apenas adicionei pra settar o  Owner
        if(dto == null) return null;
        Enviroment enviroment = new Enviroment();

        enviroment.setNameDescription(dto.nameDescription());
        enviroment.setObservation(dto.observation());
        enviroment.setState(dto.state());
        enviroment.setLocation(dto.location());
        enviroment.setOwner(owner); // *
        return enviroment;
    }



    public EnviromentDTO toDTO(Enviroment enviroment) {
        if (enviroment == null) return null;

        Long ownerId = null; // * vai servir pra verificar se o ambiente tem um dono já cadastrado e pega o id dele

        if (enviroment.getOwner() != null) {
            ownerId = enviroment.getOwner().getIdClient();
        }
        return new EnviromentDTO(
                enviroment.getIdEnviroment(),
                enviroment.getNameDescription(),
                enviroment.getObservation(),
                enviroment.isState(),
                enviroment.getLocation(),
                ownerId // * é pra enviar apenas o Id do dono, não o objeto inteiro
        );
    }


//    public EnviromentDTO toDTO(Enviroment enviroment) {
//        if (enviroment == null) return null;
//        return new EnviromentDTO(
//                enviroment.getIdEnviroment(),
//                enviroment.getNameDescription(),
//                enviroment.getObservation(),
//                enviroment.isState(),
//                enviroment.getLocation()
//        );
//    }
}
