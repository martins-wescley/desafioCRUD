package com.devsuperior.desafioCRUD.services;

import com.devsuperior.desafioCRUD.dto.ClientDTO;
import com.devsuperior.desafioCRUD.entities.Client;
import com.devsuperior.desafioCRUD.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client client = new Client();
        copyDTOToClient(client, dto);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client client = repository.getReferenceById(id);
        copyDTOToClient(client, dto);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }


    private void copyDTOToClient(Client client, ClientDTO dto) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }
}
