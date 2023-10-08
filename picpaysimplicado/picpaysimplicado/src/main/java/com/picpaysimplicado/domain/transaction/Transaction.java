package com.picpaysimplicado.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.picpaysimplicado.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa uma transação no sistema.
 */
@Entity(name = "transactions") // Indica que esta classe é uma entidade JPA com o nome "transactions".
@Table(name = "transactions") // Especifica o nome da tabela correspondente no banco de dados
                              // ("transactions").
@Getter // Gera automaticamente métodos de getter para todos os campos da classe.
@Setter // Gera automaticamente métodos de setter para todos os campos da classe.
@AllArgsConstructor /*
                     * Gera automaticamente um construtor com todos os campos da classe como
                     * argumentos.
                     */
@EqualsAndHashCode(of = "id") /*
                               * Gera métodos equals() e hashCode() usando apenas o campo 'id' para
                               * comparação.
                               */
@NoArgsConstructor
public class Transaction {

    @Id // Indica que o campo anotado é a chave primária da entidade no banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // usada para especificar a estratégia de geração de valores
                                                        // para a chave primária
    private Long id;
    private BigDecimal amount;
    @ManyToOne // Estabelece uma relação muitos-para-um com a entidade User.
    @JoinColumn(name = "sender_id") /*
                                     * Especifica o nome da coluna na tabela "transactions" que contém
                                     * a chave estrangeira para o remetente (campo sender da entidade
                                     * User).
                                     */
    private User sender;
    @ManyToOne // Estabelece uma relação muitos-para-um com a entidade User.
    @JoinColumn(name = "receiver_id") /*
                                       * Especifica o nome da coluna na tabela "transactions" que contém
                                       * a chave estrangeira para o destinatário (campo receiver da
                                       * entidade User).
                                       */
    private User receiver;
    private LocalDateTime timestamp;

}
