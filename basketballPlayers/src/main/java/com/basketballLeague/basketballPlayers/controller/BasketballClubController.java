package com.basketballLeague.basketballPlayers.controller;

import com.basketballLeague.basketballPlayers.entity.BasketballClub;
import com.basketballLeague.basketballPlayers.service.BasketballClubService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/basketballLeague")
public class BasketballClubController {
    private BasketballClubService basketballClubService;

    public BasketballClubController(BasketballClubService basketballClubService){
        this.basketballClubService = basketballClubService;
    }

    @DeleteMapping("/clubs/{uuid}")
    public void deleteBasketballCLub(@PathVariable UUID uuid){
        basketballClubService.findBasketballClubById(uuid)
                .ifPresentOrElse(basketballClub -> basketballClubService.deleteBasketballClubById(uuid),
                        () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        });
    }
    @PutMapping("/clubs/{uuid}")
    public void addBasketballClub(@PathVariable UUID uuid){
        BasketballClub basketballClub = BasketballClub.builder()
                .uuid(uuid)
                .players(new ArrayList<>())
                .build();
        basketballClubService.saveBasketballClub(basketballClub);
    }
}
