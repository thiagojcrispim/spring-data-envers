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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    @Version
    private Long version;

    protected Client() {
    }

    public Client(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }
}
