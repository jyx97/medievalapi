package br.com.fiap.medievalapi.components;

/**
Crie os enpoints do CRUD de Item. Um item
representa uma unidade que pode ser
comprada no mercado do jogo.
● nome (obrigatório)
● tipo (arma, armadura, poção, acessório)
● raridade (comum, raro, épico, lendário)
● preco (valor de venda no mercado)
● dono (relacionamento com Personagem)
*/
public enum RaridadeEnum {
    COMUM,
    RARO,
    ÉPICO,
    LENDÁRIO,
    
}
