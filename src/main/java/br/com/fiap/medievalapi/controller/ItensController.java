package br.com.fiap.medievalapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.medievalapi.model.Item;
import br.com.fiap.medievalapi.repository.ItensRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Itens")
public class ItensController {
    private final Logger log=LoggerFactory.getLogger(getClass());

    @Autowired
    private ItensRepository repository;

    //Lista todos os itens da loja
    @GetMapping
    public List<Item> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public ResponseEntity<Item> create(@RequestBody @Valid Item item){
        log.info("Adicionando item"+item.getName());
        repository.save(item);
        return ResponseEntity.status(201).body(item);
    }

    
}

// public ResponseEntity<Category> create(@RequestBody @Valid Category category) {
//     log.info("Cadastrando categoria " + category.getName());
//     repository.save(category);
//     return ResponseEntity.status(201).body(category);
// }