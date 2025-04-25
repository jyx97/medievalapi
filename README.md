# 🏰 Project of Medieval Store ⚔️

Bem-vindo ao **Projeto de Mercado Medieval**! 🌟  
Neste projeto, você irá simular um mercado medieval onde personagens podem **cadastrar**, **vender**, **comprar** e **trocar itens mágicos**, como espadas encantadas, elixires, grimórios, mantos de invisibilidade e muito mais! 🧙‍♂️⚔️

O sistema foi desenvolvido com **boas práticas de API Rest** e **POO**, criando endpoints eficientes para manipulação de personagens e itens dentro do mercado.

---

## 👥 Integrantes

- **Gabriel Dias Menezes** - RM555019
- **Julia Soares Farias dos Santos** - RM554609

---

## 🚀 Funcionalidades

### 1. **Personagens** 🧑‍💻

A API permite a manipulação completa dos personagens, com as operações **CRUD** (Criar, Ler, Atualizar, Deletar). Atributos principais de um personagem:

- **Nome** (obrigatório)
- **Classe** (guerreiro, mago, arqueiro)
- **Nível** (mínimo 1, máximo 99)
- **Moedas** (saldo para comprar itens)

### 2. **Itens Mágicos** 🛡️

A API também possibilita a gestão dos itens no mercado medieval, com os seguintes atributos:

- **Nome** (obrigatório)
- **Tipo** (arma, armadura, poção, acessório)
- **Raridade** (comum, raro, épico, lendário)
- **Preço** (valor de venda no mercado)
- **Dono** (relacionamento com Personagem)

### 3. **Filtros e Busca** 🔍

A API oferece poderosas funcionalidades de busca com base em diversos critérios. Aqui estão alguns exemplos:

- Buscar personagem por **nome**
- Buscar personagem por **classe**
- Buscar itens por **nome parcial**
- Buscar itens por **tipo**
- Buscar itens por **faixa de preço** (mínimo e máximo)
- Buscar itens por **raridade**

### 4. **Paginamento** 📄

Todos os endpoints que retornam grandes quantidades de dados implementam **paginamento**, garantindo uma boa performance e uma experiência de uso mais eficiente.

---

## ⚙️ Tecnologias Utilizadas

- **Java**
- **Spring Boot** (para criação da API)

---

## 🏃‍♂️ Como Rodar o Projeto

1. **Clone o repositório**:

```bash
git clone https://github.com/seu-usuario/medieval-store.git
```

2. **Acesse o diretório do projeto**:

```bash
cd medieval-store
```

3. **Se você estiver usando Maven, execute o comando para rodar a aplicação**:

```bash
mvn spring-boot:run
```

4. **Ou, se estiver usando Gradle**, execute:

```bash
gradle bootRun
```

5. O servidor estará rodando localmente em http://localhost:8080. 🌐

