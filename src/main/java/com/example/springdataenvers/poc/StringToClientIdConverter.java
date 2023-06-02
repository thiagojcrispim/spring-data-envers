package com.example.springdataenvers.poc;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToClientIdConverter implements Converter<String, ClientId> {

    @Override
    public ClientId convert(String source) {
        String[] parts = source.split("-");
        ClientId clientId = new ClientId();
        clientId.setId(Long.valueOf(parts[0]));
        clientId.setCpf(Long.valueOf(parts[1]));
        return clientId;
    }
}