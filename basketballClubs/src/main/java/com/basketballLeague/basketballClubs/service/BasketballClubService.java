package com.basketballLeague.basketballClubs.service;

import com.basketballLeague.basketballClubs.entity.BasketballClub;
import com.basketballLeague.basketballClubs.repository.BasketballClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BasketballClubService {
    private BasketballClubRepository basketballClubRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public BasketballClubService(BasketballClubRepository basketballClubRepository){
        this.basketballClubRepository = basketballClubRepository;
    }

    public void saveBasketballClub(BasketballClub basketballClub, UUID uuid){
        basketballClubRepository.save(basketballClub);
        restTemplate.put("/basketballLeague/clubs/{uuid}", basketballClub, uuid);
    }

    public void saveBasketballClub(BasketballClub basketballClub){
        basketballClubRepository.save(basketballClub);
    }

    public List<BasketballClub> findAllBasketballClubs(){
        return basketballClubRepository.findAll();
    }

    public BasketballClub findBasketballClubByName(String name){
        return basketballClubRepository.findBasketballClubByName(name);
    }
    public Optional<BasketballClub> findBasketballClubById(UUID uuid){
        return basketballClubRepository.findById(uuid);
    }
    public void deleteBasketballClubById(UUID uuid){
        basketballClubRepository.deleteById(uuid);
        restTemplate.delete("/basketballLeague/clubs/{uuid}", uuid);
    }
}
