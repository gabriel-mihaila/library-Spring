package com.Gabriel.project.controller;

import com.Gabriel.project.model.Client;
import com.Gabriel.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "search")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping(path = "add")
    public Client registerNewClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }

    @DeleteMapping(path = "delete/{clientID}")
    public void deleteClient(@PathVariable("clientID") Integer clientID){
        clientService.deleteClient(clientID);
    }

    @PutMapping(path = "update/{clientID}")
    public void updateClient(@PathVariable("clientID") Integer clientID, @RequestParam(required = false) String name, @RequestParam(required = false) String email,
                             @RequestParam(required = false) String address, @RequestParam(required = false) Integer age){
        clientService.updateClient(clientID, name, email, address, age);
    }
}
