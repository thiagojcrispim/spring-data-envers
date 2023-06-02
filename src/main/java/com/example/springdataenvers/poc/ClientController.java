package com.example.springdataenvers.poc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository repository;

    @GetMapping
    public Client get(@PathVariable Long cod) {
        return repository.findById(cod)
            .orElse(null);
    }

    @GetMapping("create")
    public Client create() {
        return repository.save(new Client("Thaigo", 35));
    }

    @GetMapping("update-age/{cod}/{age}")
    public Client updateAge(@PathVariable Long cod, @PathVariable Integer age) {
        return repository.findById(cod)
            .map(person -> {
                person.setAge(age);
                return repository.save(person);
            })
            .orElse(null);
    }

    @GetMapping("delete")
    public void delete(@PathVariable Long cod) {
        repository.deleteById(cod);
    }

    @GetMapping("revisions")
    public List<String> revisions() {
        return null;
        //return repository.findRevisions(1L).stream().map(Object::toString).collect(Collectors.toList());
    }
}
