package com.casino.rank.service;

import com.casino.rank.entity.PlayerEntity;
import org.springframework.stereotype.Service;

@Service
public interface IPlayerService {
    PlayerEntity getPlayer(int playerId);
    boolean updateBalance(PlayerEntity player);
    boolean savePlayer(PlayerEntity player);

    PlayerEntity getPlayerByUsername(String username);
}
