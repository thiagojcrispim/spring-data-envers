package com.example.springdataenvers.poc;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.Audited;

@Data
@Entity
@Audited
@Table(name = "person", schema = "envers")
@AuditTable(value = "person_aud", schema = "envers_audit")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    @NotAudited
    private String motherName;

    @Version
    private Long version;

    protected Person() {
    }

    public Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }
}
