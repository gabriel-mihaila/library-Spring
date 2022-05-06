package com.Gabriel.project.controller;

import com.Gabriel.project.model.Client;
import com.Gabriel.project.service.ClientService;
import com.Gabriel.project.service.ServiceFactory;
import com.Gabriel.project.service.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Client controller.
 */
@RestController
@RequestMapping(path = "api/client")
public class ClientController {

    private final ClientService clientService;


    /**
     * Instantiates a new Client controller.
     *
     * @param serviceFactory the service factory
     */
    @Autowired
    public ClientController(ServiceFactory serviceFactory) {

        this.clientService = (ClientService) serviceFactory.createService(ServiceType.CLIENT);
    }

    /**
     * Get clients list.
     *
     * @return the list
     */
    @GetMapping(path = "search")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    /**
     * Register new client client.
     *
     * @param client the client
     * @return the client
     */
    @PostMapping(path = "add")
    public Client registerNewClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }

    /**
     * Delete client.
     *
     * @param clientID the client id
     */
    @DeleteMapping(path = "delete/{clientID}")
    public void deleteClient(@PathVariable("clientID") Integer clientID){
        clientService.deleteClient(clientID);
    }

    /**
     * Update client.
     *
     * @param clientID the client id
     * @param name     the name
     * @param email    the email
     * @param address  the address
     * @param age      the age
     */
    @PutMapping(path = "update/{clientID}")
    public void updateClient(@PathVariable("clientID") Integer clientID, @RequestParam(required = false) String name, @RequestParam(required = false) String email,
                             @RequestParam(required = false) String address, @RequestParam(required = false) Integer age){
        clientService.updateClient(clientID, name, email, address, age);
    }
}
