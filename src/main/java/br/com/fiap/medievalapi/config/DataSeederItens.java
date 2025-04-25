package br.com.fiap.medievalapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.medievalapi.components.RarityEnum;
import br.com.fiap.medievalapi.components.TypeItensEnum;
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
            Item.builder().name("Poção Polissuco").type(TypeItensEnum.POÇÃO).rarity(RarityEnum.COMUM).prize(25).dono(null).build(), 
            Item.builder().name("Poção Félix Felices").type(TypeItensEnum.POÇÃO).rarity(RarityEnum.COMUM).prize(15.5).dono(null).build(), 
            Item.builder().name("Estilingue Mestre").type(TypeItensEnum.ARMA).rarity(RarityEnum.RARO).prize(200).dono(null).build(), 
            Item.builder().name("Arco de Aço").type(TypeItensEnum.ARMA).rarity(RarityEnum.COMUM).prize(25).dono(null).build(), 
            Item.builder().name("Espada das Galáxias").type(TypeItensEnum.ARMA).rarity(RarityEnum.ÉPICO).prize(1500).dono(null).build(), 
            Item.builder().name("Espada de Ferro").type(TypeItensEnum.ARMA).rarity(RarityEnum.COMUM).prize(10.8).dono(null).build(), 
            Item.builder().name("Botas de Salamandra").type(TypeItensEnum.ARMADURA).rarity(RarityEnum.COMUM).prize(30.5).dono(null).build(), 
            Item.builder().name("Capa da Invisibilidade").type(TypeItensEnum.ACESSÓRIO).rarity(RarityEnum.LENDÁRIO).prize(150).dono(null).build(), 
            Item.builder().name("Armadura de Ouro").type(TypeItensEnum.ARMADURA).rarity(RarityEnum.LENDÁRIO).prize(900).dono(null).build(), 
            Item.builder().name("Anel de Guerreiro").type(TypeItensEnum.ACESSÓRIO).rarity(RarityEnum.RARO).prize(300).dono(null).build()

        );
        repository.saveAll(itens);


    }

}