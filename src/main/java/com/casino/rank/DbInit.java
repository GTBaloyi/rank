package com.casino.rank;

import com.casino.rank.entity.PlayerEntity;
import com.casino.rank.entity.TransactionEntity;
import com.casino.rank.model.enums.TransactionType;
import com.casino.rank.repository.PlayerRepository;
import com.casino.rank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
/*
Class only used to insert sample data on application start up just for testing purposes
*/

@Component
public class DbInit {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostConstruct
    private void postConstruct(){
        insertPlayerSampleData();
    }

    private void insertTransactionSampleData() {

        List<TransactionEntity> transactionEntity = new ArrayList<>();
        PlayerEntity player = this.playerRepository.findByUsername("admin");
        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 1000));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WIN.toString(), 200));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 100));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 5));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WIN.toString(), 10));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 101));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 50));

        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 1000));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WIN.toString(), 200));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 100));

        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 1000));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WIN.toString(), 200));
        transactionEntity.add(new TransactionEntity(player, TransactionType.WAGER.toString(), 100));

        this.transactionRepository.saveAll(transactionEntity);
    }

    private void insertPlayerSampleData() {
        List<PlayerEntity> players = new ArrayList<>();
        players.add(new PlayerEntity("admin", 5000.05));
        players.add(new PlayerEntity("test", 2000.50));
        this.playerRepository.saveAll(players);
        insertTransactionSampleData();
    }
}
