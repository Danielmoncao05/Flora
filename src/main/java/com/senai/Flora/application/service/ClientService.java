package com.senai.Flora.application.service;


import com.senai.Flora.Infrastructure.dto.ClientDTO;
import com.senai.Flora.domain.ClientFlora;
import com.senai.Flora.Infrastructure.repository.ClientRepository;
import com.senai.Flora.Infrastructure.mapper.MapperClient;
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
    private MapperClient mapperClient;


    public ClientDTO registerClient (ClientDTO dto) {
    ClientFlora clientFlora = mapperClient.toEntity(dto);
    // ClientFlora save = repository.save(clientFlora);
        repository.save(clientFlora);


    return new ClientDTO(
            clientFlora.getIdClient(),
            clientFlora.getName(),
            clientFlora.getAge(),
            clientFlora.getEmail(),
            null + " senha protegida"
    );
    }

    public List<ClientDTO> listingClients () {
        return repository.findAll().stream().map(mapperClient::toDTO).collect(Collectors.toList());
    }

    public Optional<ClientDTO> searchForId (Long id) {
        return repository.findById(id).map(mapperClient::toDTO);
    }

    public boolean updateClient (Long id , ClientDTO dto){
        return repository.findById(id).map(clientFlora -> {

            clientFlora.setName(dto.name());
            clientFlora.setAge(dto.age());
            clientFlora.setEmail(dto.email());
            clientFlora.setPassword(dto.password()); // * pra caso esqueça da senha


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

    //funcao para chamada de logins pedido pelo Quidute

    public Optional<ClientDTO> getUserByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password)
                .map(mapperClient::toDTO);
    }

    //-------------------------------------------------------------------
}
