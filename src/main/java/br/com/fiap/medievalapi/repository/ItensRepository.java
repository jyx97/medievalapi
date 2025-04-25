package br.com.fiap.medievalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.medievalapi.model.Item;

public interface ItensRepository extends JpaRepository<Item, Long>,JpaSpecificationExecutor<Item>{

}