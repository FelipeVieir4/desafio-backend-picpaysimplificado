package com.picpaysimplicado.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration /*
                * Esta anotação é usada para indicar que a classe AppConfig é uma classe de
                * configuração Spring. Classes de configuração Spring contêm métodos que
                * definem beans.
                */
public class AppConfig {
    @Bean /*
           * sta anotação é usada em métodos de uma classe de configuração para indicar
           * que um bean deve ser configurado no contêiner Spring
           */
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
/*
 * Em contexto de programação, especialmente em frameworks de injeção de
 * dependência como o Spring Framework, um "bean" é um objeto que é instanciado,
 * gerenciado e injetado por um container. No Spring Framework, os beans são
 * objetos Java que são tratados pelo contêiner Spring. Eles são gerenciados
 * pelo contêiner e podem ser configurados, inicializados e destruídos pelo
 * próprio Spring, permitindo uma fácil integração e gerenciamento de
 * componentes em uma aplicação.
 * 
 * Os beans no Spring Framework são geralmente classes Java, mas podem ser
 * qualquer objeto Java, incluindo instâncias de classes, valores primitivos ou
 * até outras configurações de beans. Os beans são definidos por meio de
 * configuração, geralmente usando anotações
 * (@Component, @Service, @Repository, @Controller ou @Configuration) ou XML,
 * dependendo do estilo de configuração preferido.
 * 
 * Ao definir um bean, você permite que o Spring Framework gerencie seu ciclo de
 * vida, como criação, configuração e destruição, e também facilita a injeção de
 * dependência. A injeção de dependência é um padrão de design no qual as
 * dependências de um objeto são injetadas nele, em vez de o objeto criar suas
 * próprias dependências. Isso facilita a manutenção, teste e reutilização de
 * componentes.
 * 
 * No exemplo que você forneceu anteriormente, o método restTemplate() na classe
 * de configuração AppConfig é anotado com @Bean, indicando que um bean do tipo
 * RestTemplate será configurado e gerenciado pelo contêiner Spring. Esse bean
 * pode então ser injetado em outras partes da aplicação onde for necessário
 * fazer chamadas HTTP para APIs RESTful.
 */