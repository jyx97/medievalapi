package br.com.fiap.medievalapi.model;

import br.com.fiap.medievalapi.components.RarityEnum;
import br.com.fiap.medievalapi.components.TypeItensEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Crie os enpoints do CRUD de Item. Um item
representa uma unidade que pode ser
comprada no mercado do jogo.
● nome (obrigatório)
● tipo (arma, armadura, poção, acessório)
● raridade (comum, raro, épico, lendário)
● preco (valor de venda no mercado)
● dono (relacionamento com Personagem)
*/
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    @NotBlank(message="Nome é obrigatório")
    private String name;

    @NotBlank(message="Tipo é obrigatório")
    private TypeItensEnum type;

    @NotBlank(message="A raridade é obrigatória")
    private RarityEnum rarity;

    @NotBlank(message="O preço é obrigatório")
    private double prize;

    private Personagem dono;
}
