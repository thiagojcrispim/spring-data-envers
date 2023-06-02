package com.example.springdataenvers.poc;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository repository;

    @GetMapping
    public Person get(@PathVariable Long cod) {
        return repository.findById(cod)
                .orElse(null);
    }

    @GetMapping("create")
    public Person create() {
        return repository.save(new Person("José", 40));
    }

    @GetMapping("update-age/{cod}/{age}")
    public Person updateAge(@PathVariable Long cod, @PathVariable Integer age) {
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
