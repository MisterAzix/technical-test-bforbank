package com.bforbank.moneypot.domain.repository;

import java.util.Optional;
import com.bforbank.moneypot.domain.entity.Client;


public interface ClientRepository {
    Optional<Client> findById(Long id);
    void save(Client client);
}
