package com.basketballLeague.basketballPlayers.service;

import com.basketballLeague.basketballPlayers.entity.BasketballClub;
import com.basketballLeague.basketballPlayers.repository.BasketballClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BasketballClubService {
    private BasketballClubRepository basketballClubRepository;

    @Autowired
    public BasketballClubService(BasketballClubRepository basketballClubRepository){
        this.basketballClubRepository = basketballClubRepository;
    }

    public void saveBasketballClub(BasketballClub basketballClub){
        basketballClubRepository.save(basketballClub);
    }

    public Optional<BasketballClub> findBasketballClubById(UUID uuid){
        return basketballClubRepository.findById(uuid);
    }
    public void deleteBasketballClubById(UUID uuid){
        basketballClubRepository.deleteById(uuid);
    }
}
