package com.basketballLeague.basketballClubs.controller;

import com.basketballLeague.basketballClubs.dto.GetBasketballClubResponse;
import com.basketballLeague.basketballClubs.dto.GetBasketballClubsResponse;
import com.basketballLeague.basketballClubs.dto.PatchBasketballClubRequest;
import com.basketballLeague.basketballClubs.dto.PutBasketballClubRequest;
import com.basketballLeague.basketballClubs.entity.BasketballClub;
import com.basketballLeague.basketballClubs.service.BasketballClubService;
import com.basketballLeague.basketballClubs.translator.BasketballClubToGetBasketballClubResponse;
import com.basketballLeague.basketballClubs.translator.BasketballClubsToGetBasketballClubsResponse;
import com.basketballLeague.basketballClubs.translator.PutBasketballClubRequestToBasketballClub;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/basketballLeague")
public class BasketballClubController {
    private BasketballClubService basketballClubService;
    private BasketballClubsToGetBasketballClubsResponse basketballClubsToGetBasketballClubsResponse;
    private BasketballClubToGetBasketballClubResponse basketballClubToGetBasketballClubResponse;
    private PutBasketballClubRequestToBasketballClub putBasketballClubRequestToBasketballClub;

    public BasketballClubController(BasketballClubService basketballClubService,
                                    BasketballClubsToGetBasketballClubsResponse basketballClubsToGetBasketballClubsResponse,
                                    BasketballClubToGetBasketballClubResponse basketballClubToGetBasketballClubResponse,
                                    PutBasketballClubRequestToBasketballClub putBasketballClubRequestToBasketballClub){
        this.basketballClubService = basketballClubService;
        this.basketballClubsToGetBasketballClubsResponse = basketballClubsToGetBasketballClubsResponse;
        this.basketballClubToGetBasketballClubResponse = basketballClubToGetBasketballClubResponse;
        this.putBasketballClubRequestToBasketballClub = putBasketballClubRequestToBasketballClub;
    }

    @GetMapping("/clubs")
    public GetBasketballClubsResponse getAllBasketballClubs(){
        return basketballClubsToGetBasketballClubsResponse.translate(basketballClubService.findAllBasketballClubs());
    }

    @GetMapping("/clubs/{uuid}")
    public GetBasketballClubResponse getBasketballClub(@PathVariable UUID uuid){
        return basketballClubToGetBasketballClubResponse.translate(basketballClubService.findBasketballClubById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @DeleteMapping("/clubs/{uuid}")
    public void deleteBasketballCLub(@PathVariable UUID uuid){
        basketballClubService.findBasketballClubById(uuid)
                .ifPresentOrElse(basketballClub -> basketballClubService.deleteBasketballClubById(uuid),
                        () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        });
    }

    @PutMapping("clubs/{uuid}")
    public void putBasketballClub(@PathVariable UUID uuid, @RequestBody PutBasketballClubRequest putBasketballClubRequest){
        if(basketballClubService.findBasketballClubById(uuid).isPresent())
            throw new ResponseStatusException(HttpStatus.FOUND);
        else
            basketballClubService.saveBasketballClub(putBasketballClubRequestToBasketballClub
                    .translate(uuid, putBasketballClubRequest), uuid);
    }

    @PatchMapping("clubs/{uuid}")
    public void updateBasketballClub(@PathVariable UUID uuid, @RequestBody PatchBasketballClubRequest patchBasketballClubRequest){
        BasketballClub basketballClub = basketballClubService.findBasketballClubById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        basketballClub.setName(patchBasketballClubRequest.getName());
        basketballClub.setFoundationYear(patchBasketballClubRequest.getFoundationYear());
        basketballClubService.saveBasketballClub(basketballClub);
    }
}
