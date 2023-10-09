package com.picpaysimplicado.domain.user;

import java.math.BigDecimal;

import com.picpaysimplicado.dtos.UserDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa um usuário no sistema.
 */
@Entity(name = "users") // Indica que esta classe é uma entidade JPA com o nome "users".
@Table(name = "users") // Especifica o nome da tabela correspondente no banco de dados ("users").
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
public class User {

    @Id // ndica que o campo anotado é a chave primária da entidade no banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // usada para especificar a estratégia de geração de valores
                                                        // para a chave primária
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true) // Garante que o valor desta coluna no banco de dados seja único.
    private String document;
    @Column(unique = true) // Garante que o valor desta coluna no banco de dados seja único.
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING) /*
                                  * Especifica que o tipo do campo no banco de dados será uma string
                                  * representando a enumeração.
                                  */
    private UserType userType;

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.email = data.email();
        this.document = data.document();
    }

}
