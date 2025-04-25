package br.com.fiap.medievalapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.medievalapi.components.ClassEnum;
import br.com.fiap.medievalapi.components.RarityEnum;
import br.com.fiap.medievalapi.components.TypeItensEnum;
import br.com.fiap.medievalapi.model.Item;
import br.com.fiap.medievalapi.model.Personagem;
import br.com.fiap.medievalapi.repository.ItensRepository;
import br.com.fiap.medievalapi.repository.PersonagemRepository;
import jakarta.annotation.PostConstruct;


/*
 @Autowired
    private PersonagemRepository personagemRepository;  // Repositório para salvar os personagens

    @PostConstruct
    public void init() {
        
        // Criação dos personagens para associar aos itens
        Personagem guerreiro = Personagem.builder()
            .name("Guerreiro Valente")
            .typeClass(ClassEnum.GUERREIRO)
            .level(50)
            .coins(1000)
            .build();

        Personagem mago = Personagem.builder()
            .name("Mago Ancião")
            .typeClass(ClassEnum.MAGO)
            .level(40)
            .coins(500)
            .build();

        Personagem arqueiro = Personagem.builder()
            .name("Arqueiro Sombrio")
            .typeClass(ClassEnum.ARQUEIRO)
            .level(60)
            .coins(1200)
            .build();

        // Salvando os personagens no banco
        personagemRepository.saveAll(List.of(guerreiro, mago, arqueiro));
*/

@Component
public class DataSeederItens {

    @Autowired
    private ItensRepository Itensrepository;
    @Autowired
    private PersonagemRepository personagemRepository;  // Repositório para salvar os personagens

    @PostConstruct
    public void init(){
        var personagens=List.of(
            Personagem.builder().name("Guerreiro Valente").typeClass(ClassEnum.GUERREIRO).level(50).coins(1000).build(), 
            Personagem.builder().name("Mago Ancião").typeClass(ClassEnum.MAGO).level(40).coins(500).build(), 
            Personagem.builder().name("Arqueiro Sombrio").typeClass(ClassEnum.ARQUEIRO).level(60).coins(1200).build()
        );

        personagemRepository.saveAll(personagens);
        
        var itens = List.of(
            Item.builder().name("Poção Polissuco").type(TypeItensEnum.POÇÃO).rarity(RarityEnum.COMUM).prize(25).dono(personagens.get(0)).build(), 
            Item.builder().name("Poção Félix Felices").type(TypeItensEnum.POÇÃO).rarity(RarityEnum.COMUM).prize(15.5).dono(null).build(), 
            Item.builder().name("Estilingue Mestre").type(TypeItensEnum.ARMA).rarity(RarityEnum.RARO).prize(200).dono(null).build(), 
            Item.builder().name("Arco de Aço").type(TypeItensEnum.ARMA).rarity(RarityEnum.COMUM).prize(25).dono(personagens.get(1)).build(), 
            Item.builder().name("Espada das Galáxias").type(TypeItensEnum.ARMA).rarity(RarityEnum.ÉPICO).prize(1500).dono(null).build(), 
            Item.builder().name("Espada de Ferro").type(TypeItensEnum.ARMA).rarity(RarityEnum.COMUM).prize(10.8).dono(null).build(), 
            Item.builder().name("Botas de Salamandra").type(TypeItensEnum.ARMADURA).rarity(RarityEnum.COMUM).prize(30.5).dono(null).build(), 
            Item.builder().name("Capa da Invisibilidade").type(TypeItensEnum.ACESSÓRIO).rarity(RarityEnum.LENDÁRIO).prize(150).dono(null).build(), 
            Item.builder().name("Armadura de Ouro").type(TypeItensEnum.ARMADURA).rarity(RarityEnum.LENDÁRIO).prize(900).dono(personagens.get(2)).build(), 
            Item.builder().name("Anel de Guerreiro").type(TypeItensEnum.ACESSÓRIO).rarity(RarityEnum.RARO).prize(300).dono(null).build()

        );
        Itensrepository.saveAll(itens);


    }

}