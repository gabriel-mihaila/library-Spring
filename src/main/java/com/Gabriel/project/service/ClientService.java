package com.Gabriel.project.service;

import com.Gabriel.project.model.Client;
import com.Gabriel.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Client service.
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    /**
     * Instantiates a new Client service.
     *
     * @param clientRepository the client repository
     */
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Get clients list.
     *
     * @return the list
     */
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    /**
     * Add new client client.
     *
     * @param client the client
     * @return the client
     */
    public Client addNewClient(Client client) {
        Optional<Client> clientByEmail = clientRepository.findByEmail(client.getEmail());

        if(clientByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        return clientRepository.save(client);
    }

    /**
     * Delete client.
     *
     * @param clientID the client id
     */
    public void deleteClient(Integer clientID) {
        boolean exists = clientRepository.existsById(clientID);
        if(!exists){
            throw new IllegalStateException("Client with id " + clientID + " does not exists");
        }
        clientRepository.deleteById(clientID);
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
    @Transactional
    public void updateClient(Integer clientID, String name, String email, String address, Integer age) {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new IllegalStateException("Client with id " + clientID + " does not exists"));

        if(name != null && !client.getName().equals(name)){
            client.setName(name);
        }

        if(email != null && email.length() > 4 && !client.getEmail().equals(email)){

            Optional<Client> clientByEmail = clientRepository.findByEmail(email);

            if(clientByEmail.isPresent()) {
                throw new IllegalStateException("Email taken");
            }

            client.setEmail(email);
        }

        if(address != null && !client.getAddress().equals(address)){
            client.setAddress(address);
        }

        if(age != null && age > 6 && client.getAge() != age){
            client.setAge(age);
        }

    }
}
