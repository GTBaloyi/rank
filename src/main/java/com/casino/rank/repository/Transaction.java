package com.casino.rank.repository;

import com.casino.rank.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Transaction extends CrudRepository<TransactionEntity, Integer> {
}
