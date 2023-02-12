package com.casino.rank.service.impl;

import com.casino.rank.entity.PlayerEntity;
import com.casino.rank.entity.TransactionEntity;
import com.casino.rank.repository.TransactionRepository;
import com.casino.rank.service.ITransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService implements ITransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionEntity getTransactionByPlayer(PlayerEntity player) {
       return this.transactionRepository.findByPlayerId(player);
    }

    @Override
    public TransactionEntity saveTransaction(TransactionEntity transaction) {
        return this.transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionEntity> getTransactionByUsername(PlayerEntity player, int limit) {
        List<TransactionEntity> transactions = this.transactionRepository.findAllByPlayerIdOrderByLastModified(player);
        return limit == 0 ? transactions : transactions.stream().limit(limit).collect(Collectors.toList()) ;
    }
}
