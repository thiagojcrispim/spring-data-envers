package com.example.springdataenvers.poc;

import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(final Object entity) {
        CustomRevisionEntity revision = (CustomRevisionEntity) entity;
        revision.setUsuario("ADMIN"); //Spring Security
    }
}
