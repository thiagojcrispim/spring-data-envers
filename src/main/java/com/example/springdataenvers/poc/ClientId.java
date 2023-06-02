package com.example.springdataenvers.poc;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
@Data
public class ClientId implements Serializable {
    private Long id;
    private Long cpf;

    // Gets and Sets...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientId)) return false;
        ClientId clientId = (ClientId) o;
        return Objects.equals(id, clientId.id) &&
                Objects.equals(cpf, clientId.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

    }