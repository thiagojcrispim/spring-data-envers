package com.example.springdataenvers.poc;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@Table(name = "revinfo", schema = "envers_audit")
@RevisionEntity(CustomRevisionListener.class)
@Data
@ToString(callSuper = true)
public class CustomRevisionEntity extends DefaultRevisionEntity {

    private String usuario;
}
