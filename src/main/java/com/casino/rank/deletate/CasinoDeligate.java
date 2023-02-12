package com.casino.rank.deletate;

import com.casino.rank.entity.PlayerEntity;
import com.casino.rank.entity.TransactionEntity;
import com.casino.rank.model.enums.TransactionType;
import com.casino.rank.model.request.TransactionRequest;
import com.casino.rank.model.request.UpdateBalanceRequest;
import com.casino.rank.model.response.GetBalanceResponse;
import com.casino.rank.model.response.TransactionsResponse;
import com.casino.rank.model.response.UpdateBalanceResponse;
import com.casino.rank.service.IPlayerService;
import com.casino.rank.service.ITransactionService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CasinoDeligate {
    private IPlayerService playerService;
    private ITransactionService transactionService;

    public CasinoDeligate(IPlayerService playerService, ITransactionService transactionService) {
        this.playerService = playerService;
        this.transactionService = transactionService;
    }

    public GetBalanceResponse getPlayerBalance(int playerId) {
        PlayerEntity player = this.playerService.getPlayer(playerId);
        if(player != null) {
            return new GetBalanceResponse(playerId, player.getBalance());
        } else {
            throw new NoSuchElementException("Record not found");
        }
    }

    @Transactional
    public UpdateBalanceResponse updatePlayerBalance(int playerId, UpdateBalanceRequest request) {
        PlayerEntity player = this.playerService.getPlayer(playerId);
        if(player != null) {
            if(request.getTransactionType() == TransactionType.WAGER && request.getAmount() > player.getBalance()) {
                throw new RuntimeException("Amount cannot be greater than balance");
            }

            TransactionEntity transaction =this.transactionService.saveTransaction(new TransactionEntity(player,request.getTransactionType().toString(),request.getAmount()));
            player.setBalance(request.getAmount());
            this.transactionService.saveTransaction(transaction);
            this.playerService.updateBalance(player);
            return new UpdateBalanceResponse(BigInteger.valueOf(transaction.getId()),player.getBalance());

        } else {
            throw new NoSuchElementException();
        }
    }

    public List<TransactionsResponse> lastTenTransactions(TransactionRequest request) {
        PlayerEntity player = this.playerService.getPlayerByUsername(request.getUsername());
        if(player != null) {
            List<TransactionEntity> transactions = this.transactionService.getTransactionByUsername(player, 10);
            List<TransactionsResponse> response = new ArrayList<>();

            for(TransactionEntity transaction: transactions) {
                response.add(new TransactionsResponse(TransactionType.valueOf(transaction.getType()), BigInteger.valueOf(transaction.getId()),transaction.getAmount()));
            }

            return response;
        } else {
            throw new NoSuchElementException("Record not found");
        }

    }
}
