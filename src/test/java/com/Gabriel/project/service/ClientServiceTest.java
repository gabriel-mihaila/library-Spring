package com.Gabriel.project.service;

import com.Gabriel.project.model.Client;
import com.Gabriel.project.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Client service test.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Autowired
    private ClientService underTest;

    /**
     * Set up.
     */
    @BeforeEach
    void setUp(){
        underTest = new ClientService(clientRepository);
    }

    /**
     * Gets clients.
     */
    @Test
    void getClients() {
        underTest.getClients();
        verify(clientRepository).findAll();

    }

    /**
     * Add new client.
     */
    @Test
    void addNewClient() {
        Client client = new Client("Marius", "Livezii 11", "danbadea@gmail.com", 18);
        Client client2 = new Client("Marius2", "Livezii 11", "danbadea2@gmail.com", 18);
        underTest.addNewClient(client);
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepository).save(clientArgumentCaptor.capture());
        Client capturedClient = clientArgumentCaptor.getValue();
        assertThat(capturedClient).isEqualTo(client);
    }
}