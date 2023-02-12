package com.casino.rank.repository;

import com.casino.rank.entity.PlayerEntity;
import com.casino.rank.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    TransactionEntity findByPlayerId(PlayerEntity playerId);
    List<TransactionEntity> findAllByPlayerIdOrderByLastModified(PlayerEntity playerId);
}
