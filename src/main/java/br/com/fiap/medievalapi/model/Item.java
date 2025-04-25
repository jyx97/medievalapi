package br.com.fiap.medievalapi.model;

import br.com.fiap.medievalapi.components.RarityEnum;
import br.com.fiap.medievalapi.components.TypeItensEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotNull(message="Tipo é obrigatório")
    private TypeItensEnum type;

    @NotNull(message="A raridade é obrigatória")
    private RarityEnum rarity;

    @NotNull(message="O preço é obrigatório")
    private double prize;

    @ManyToOne
    @JoinColumn(name="character_id")
    private Personagem dono;
}
