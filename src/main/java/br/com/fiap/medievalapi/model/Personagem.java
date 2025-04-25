package br.com.fiap.medievalapi.model;

import br.com.fiap.medievalapi.components.ClassEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    @NotNull(message = "A classe é obrigatória")
    private ClassEnum typeClass; 
    
    @NotNull(message = "O nível é obrigatório")
    @Min(value = 1, message = "O nível deve ser maior que 0")
    @Max(value = 99, message = "O nível deve ser no máximo 99")
    private int level; 
    
    @NotNull(message = "As moedas são obrigatório")
    @PositiveOrZero(message = "As moedas devem ser maior ou igual a 0")
    private double coins;
}
