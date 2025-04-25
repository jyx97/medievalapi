package br.com.fiap.medievalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.medievalapi.model.Item;
import br.com.fiap.medievalapi.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>{

}