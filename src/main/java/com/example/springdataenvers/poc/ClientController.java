package com.example.springdataenvers.poc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository repository;

    @GetMapping
    public Client get(@PathVariable ClientId cod) {
        return repository.findById(cod)
            .orElse(null);
    }

    @GetMapping("create")
    public Client create() {
        return repository.save(new Client(1L,999L,"Thaigo", 35));
    }

    @PostMapping("update-age/{cod}")
    public Client updateAge(@PathVariable ClientId cod, @RequestBody UpdateAgeDTO newAge) {
        return repository.findById(cod)
                .map(client -> {
                    client.setAge(newAge.getAge());
                    return repository.save(client);
                })
                .orElse(null);
    }

    @GetMapping("delete")
    public void delete(@PathVariable ClientId cod) {
        repository.deleteById(cod);
    }

    @GetMapping("revisions")
    public List<String> revisions() {
        return null;
        //return repository.findRevisions(1L).stream().map(Object::toString).collect(Collectors.toList());
    }
}
