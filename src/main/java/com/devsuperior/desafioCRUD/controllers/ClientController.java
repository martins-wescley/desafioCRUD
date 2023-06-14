package com.devsuperior.desafioCRUD.controllers;

import com.devsuperior.desafioCRUD.entities.Client;
import com.devsuperior.desafioCRUD.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;
    @GetMapping
    public String teste(){
        Optional<Client> result =  repository.findById(1L);
        Client client = result.get();
        return client.getName();
    }

}
