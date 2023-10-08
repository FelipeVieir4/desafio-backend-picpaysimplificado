
/*Em Java, as classes DTO (Data Transfer Object) são usadas para transferir dados entre camadas de uma aplicação, 
como por exemplo entre a camada de controle (controller) e a camada de persistência (repository). Essas classes 
geralmente contêm apenas campos de dados (geralmente privados) e métodos de acesso (getters e setters) para esses campos. 
Elas são usadas para encapsular dados e transferi-los entre diferentes partes do sistema, muitas vezes em operações de entrada e saída, 
como quando você precisa enviar dados de um formulário HTML para o servidor. */
package com.picpaysimplicado.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderId, Long receiverId) {
    // Nenhum método adicional é necessário,
    // pois o Java automaticamente gera equals(), hashCode(), toString() e métodos de acesso.
}
