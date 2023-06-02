package com.example.springdataenvers.poc;

import lombok.Data;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Data
@Entity
@Audited
@Table(name = "client", schema = "envers")
@AuditTable(value = "client_aud", schema = "envers_audit")
public class Client {

    @EmbeddedId
    private ClientId id;

    private String name;

    private Integer age;

    @Version
    private Long version;

    protected Client() {
    }

    public Client(final Long id, final Long cpf, final String name, final Integer age) {
        this.id = new ClientId();
        this.id.setId(id);
        this.id.setCpf(cpf);
        this.name = name;
        this.age = age;
    }
}
