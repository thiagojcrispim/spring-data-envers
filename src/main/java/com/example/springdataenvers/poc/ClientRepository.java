package com.example.springdataenvers.poc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface ClientRepository extends
        JpaRepository<Client, ClientId>,
        RevisionRepository<Client, ClientId, Long> {
}