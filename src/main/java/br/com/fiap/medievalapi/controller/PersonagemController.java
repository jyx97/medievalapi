package br.com.fiap.medievalapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.medievalapi.dto.PersonagemFilter;
import br.com.fiap.medievalapi.model.Personagem;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.fiap.medievalapi.repository.PersonagemRepository;
import br.com.fiap.medievalapi.specification.PersonagemSpecification;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonagemRepository repository;

    @GetMapping
    public List<Personagem> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Personagem> create(@RequestBody @Valid Personagem personagem) {
        log.info("Cadastrando Personagem: " + personagem.getName());
        repository.save(personagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(personagem);
    }

    @GetMapping("{id}")
    public ResponseEntity<Personagem> buscarPersonagem(@PathVariable Long id) {
        log.info("Buscando Personagem " + id);
        Personagem personagem = getPersonagem(id);
        return ResponseEntity.ok(personagem);
    }

    @PutMapping("{id}")
    public ResponseEntity<Personagem> atualizar(@PathVariable Long id, @RequestBody @Valid Personagem personagemAtualizado) {
        log.info("Atualizando Personagem " + id);

        Personagem personagem = getPersonagem(id); // Verifica se existe
        personagem.setName(personagemAtualizado.getName());
        personagem.setTypeClass(personagemAtualizado.getTypeClass());
        personagem.setLevel(personagemAtualizado.getLevel());

        repository.save(personagem);
        return ResponseEntity.ok(personagem);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        log.info("Deletando Personagem " + id);
        Personagem personagem = getPersonagem(id);
        repository.delete(personagem);
    }

    // Método utilitário para validar se o personagem existe
    private Personagem getPersonagem(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Personagem não encontrado"));
    }
    @GetMapping("/search")
    public Page<Personagem> searchPersona(
            PersonagemFilter filters,
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {

        var specification = PersonagemSpecification.comFiltros(
                filters.name(), filters.typeClass());

        return repository.findAll(specification, pageable);
    }
}
