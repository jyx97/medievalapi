package br.com.fiap.medievalapi.model;

import br.com.fiap.medievalapi.components.ClassEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*
Crie o CRUD de personagem com os
endpoints básicos para manipulação de
dados e persistência em BD.
● nome (obrigatório)
● classe (guerreiro, mago, arqueiro)
● nivel (mínimo 1, máximo 99)
● moedas (saldo para comprar itens)

*/
@Entity
@Data
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    @NotBlank(message = "A classe é obrigatória")
    private ClassEnum typeClass; 
    
    @NotBlank(message = "O nível é obrigatório")
    @Size(min = 1, max = 99)
    private int level; 
    
    @NotBlank(message = "As moedas são obrigatório")
    private double coins;

    public Personagem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassEnum getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(ClassEnum typeClass) {
        this.typeClass = typeClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }
}
