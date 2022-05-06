package com.Gabriel.project.repository;

import com.Gabriel.project.model.Client;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Client repository test.
 */
@SpringBootTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository underTest;

    /**
     * Find by email test.
     */
    @Test
    void findByEmailTest() {
        String email = "danbadea@gmail.com";
        Client client = new Client("Marius", "Livezii 11", email, 18);
        underTest.save(client);
        Optional<Client> exists = underTest.findByEmail(email);
        underTest.delete(client);
        assertThat(exists).isPresent();

    }

    /**
     * Find all test.
     */
    @Test
    @Disabled
    void findAllTest()
    {

    }
}