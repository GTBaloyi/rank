package com.casino.rank.service;

import com.casino.rank.entity.PlayerEntity;
import com.casino.rank.entity.TransactionEntity;

import java.util.List;

public interface ITransactionService {
    TransactionEntity getTransactionByPlayer(PlayerEntity player);
    TransactionEntity saveTransaction(TransactionEntity transaction);

    List<TransactionEntity> getTransactionByUsername(PlayerEntity player, int limit);
}
