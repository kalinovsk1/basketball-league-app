package com.basketballLeague.basketballPlayers.service;

import com.basketballLeague.basketballPlayers.entity.Player;
import com.basketballLeague.basketballPlayers.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void savePlayer(Player player){
        playerRepository.save(player);
    }

    public List<Player> findAllPlayers(){
        return playerRepository.findAll();
    }

    public Optional<Player> findPlayerById(UUID uuid){
        return playerRepository.findById(uuid);
    }

    public List<Player> findPlayerByBasketballClubId(UUID uuid){
        return playerRepository.findByBasketballClub_Uuid(uuid);
    }
    public void deletePlayerById(UUID uuid){
        playerRepository.deleteById(uuid);
    }
    public void deletePlayerByName(String name){
        playerRepository.deletePlayerByName(name);
    }
}
