package br.com.fiap.medievalapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.medievalapi.model.Item;
import br.com.fiap.medievalapi.repository.ItensRepository;
import jakarta.annotation.PostConstruct;


/*
● nome (obrigatório)
● tipo (arma, armadura, poção, acessório)
● raridade (comum, raro, épico, lendário)
● preco (valor de venda no mercado)
● dono (relacionamento com Personagem)
*/

@Component
public class DataSeederItens {

    @Autowired
    private ItensRepository repository;

    @PostConstruct
    public void init(){

        var itens = List.of(
            Item.builder().name("Poção Polissuco").type("POÇÃO").rarity("Comum").prize(25).dono(null).build(), 
            Item.builder().name("Poção Félix Felices").type("POÇÃO").rarity("Comum").prize(15.5).dono(null).build(), 
            Item.builder().name("Estilingue Mestre").type("ARMA").rarity("Comum").prize(25).dono(null).build(), 
            Item.builder().name("Estilingue Mestre").type("ARMA").rarity("Comum").prize(25).dono(null).build(), 
            Item.builder().name("Espada das Galáxias").type("ARMA").rarity("Épico").prize(1500).dono(null).build(), 
            Item.builder().name("Espada de Ferro").type("ARMA").rarity("Comum").prize(10.8).dono(null).build(), 
            Item.builder().name("").type("Poção").rarity("Comum").prize(15.5).dono(null).build(), 

        );
//
        repository.saveAll(itens);


    }

}