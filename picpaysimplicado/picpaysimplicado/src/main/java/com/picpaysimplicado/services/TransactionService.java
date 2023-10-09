package com.picpaysimplicado.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplicado.domain.transaction.Transaction;
import com.picpaysimplicado.domain.user.User;
import com.picpaysimplicado.dtos.TransactionDTO;
import com.picpaysimplicado.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());
        if (!isAuthorized) {
            throw new Exception("transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        ;
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.repository.save(newTransaction);
        this.userService.saveUser(receiver);
        this.userService.saveUser(sender);
        // this.notificationService.sendNotification(sender, "Transação realizada com sucesso");
        // this.notificationService.sendNotification(receiver, "Transação recebida com sucesso");

        return newTransaction;

    }

    // consultando serviço externo
    public boolean authorizeTransaction(User sender, BigDecimal value) {
        // String url = "https://url.....";
        // ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity(url, Map.class);

        // if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
        //     String message = (String) authorizationResponse.getBody().get("message");
        //     return "Autorizado".equalsIgnoreCase(message);
        // }

        return true;
    }

}
