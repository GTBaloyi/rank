package com.casino.rank.service.impl;

import com.casino.rank.entity.PlayerEntity;
import com.casino.rank.repository.PlayerRepository;
import com.casino.rank.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerEntity getPlayer(int playerId) {
        return this.playerRepository.findById(playerId).orElse(null);
    }

    @Override
    public boolean updateBalance(PlayerEntity player) {
        playerRepository.save(player);
        return true;
    }

    @Override
    public boolean savePlayer(PlayerEntity player) {
        return false;
    }

    @Override
    public PlayerEntity getPlayerByUsername(String username) {
       return this.playerRepository.findByUsername(username);
    }
}
