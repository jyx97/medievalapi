package br.com.fiap.medievalapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.medievalapi.model.Personagem;
import br.com.fiap.medievalapi.repository.PersonagemRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonagemRepository repository;

    @GetMapping
    public List<Personagem> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public ResponseEntity<Personagem> create(@RequestBody @Valid Personagem personagem){
        log.info("Cadastrando Personagem"+ personagem.getName());
        repository.save(personagem);
        return ResponseEntity.status(201).body(personagem);
    }

    @GetMapping("{id}")
    public ResponseEntity<Personagem> buscarPersonagem(@PathVariable Long id) {
        log.info("Buscando Personagem " + id);
        return getPersonagem(id);
    }

    private Personagem getPersonagem(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));
    }
}
    
