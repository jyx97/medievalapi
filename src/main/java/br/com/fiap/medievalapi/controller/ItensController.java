package br.com.fiap.medievalapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.medievalapi.components.RarityEnum;
import br.com.fiap.medievalapi.components.TypeItensEnum;
import br.com.fiap.medievalapi.model.Item;
import br.com.fiap.medievalapi.repository.ItensRepository;
import br.com.fiap.medievalapi.specification.ItemSpecification;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Itens")
public class ItensController {
    private final Logger log=LoggerFactory.getLogger(getClass());

    @Autowired
    private ItensRepository repository;

    public record ItensFilter(String name,TypeItensEnum type,Double minPrice,Double maxPrice,RarityEnum rarity){}

    @GetMapping
    public Page<Item> index(ItensFilter filters,Pageable pageable){
        var specification=ItemSpecification.withFilters(filters);
        return repository.findAll(specification,pageable);
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public ResponseEntity<Item> create(@RequestBody @Valid Item item){
        log.info("Adicionando item"+item.getName());
        repository.save(item);
        return ResponseEntity.status(201).body(item);
    }
    @GetMapping("{id}")
    public Item get(@PathVariable Long id){
        log.info("buscando item"+id);
        return getItem(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Apagando item"+id);
        repository.delete(getItem(id));
    }

    @PutMapping("{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item){
        log.info("Atualizando item"+id+"para"+item);
        item.setId(id);
        return repository.save(item);
    }

    private Item getItem(Long id){
        return repository.findById(id)
                         .orElseThrow(
                            ()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    
    
}
