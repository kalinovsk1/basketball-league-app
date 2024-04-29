package com.basketballLeague.basketballPlayers.controller;

import com.basketballLeague.basketballPlayers.dto.GetPlayerResponse;
import com.basketballLeague.basketballPlayers.dto.GetPlayersResponse;
import com.basketballLeague.basketballPlayers.dto.PatchPlayerRequest;
import com.basketballLeague.basketballPlayers.dto.PutPlayerRequest;
import com.basketballLeague.basketballPlayers.entity.Player;
import com.basketballLeague.basketballPlayers.service.BasketballClubService;
import com.basketballLeague.basketballPlayers.service.PlayerService;
import com.basketballLeague.basketballPlayers.translator.PlayerToGetPlayerResponse;
import com.basketballLeague.basketballPlayers.translator.PlayersToGetPlayersResponse;
import com.basketballLeague.basketballPlayers.translator.PutPlayerRequestToPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/basketballLeague")
public class PlayerController {
    private PlayerService playerService;
    private BasketballClubService basketballClubService;
    private PlayerToGetPlayerResponse playerToGetPlayerResponse;
    private PlayersToGetPlayersResponse playersToGetPlayersResponse;

    private PutPlayerRequestToPlayer putPlayerRequestToPlayer;

    @Autowired
    public PlayerController(PlayerService playerService,
                            BasketballClubService basketballClubService,
                            PlayerToGetPlayerResponse playerToGetPlayerResponse,
                            PlayersToGetPlayersResponse playersToGetPlayersResponse,
                            PutPlayerRequestToPlayer putPlayerRequestToPlayer){
        this.playerService = playerService;
        this.basketballClubService = basketballClubService;
        this.playerToGetPlayerResponse = playerToGetPlayerResponse;
        this.playersToGetPlayersResponse = playersToGetPlayersResponse;
        this.putPlayerRequestToPlayer = putPlayerRequestToPlayer;
    }

    @GetMapping("/players/{uuid}")
    public GetPlayerResponse getPlayer(@PathVariable UUID uuid){
        return playerToGetPlayerResponse.translate(playerService.findPlayerById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/players")
    public GetPlayersResponse getAllPlayers(){
        return playersToGetPlayersResponse.translate(playerService.findAllPlayers());
    }

    @GetMapping("/clubs/{uuid}/players")
    public GetPlayersResponse getPlayersFromClub(@PathVariable UUID uuid){
        basketballClubService.findBasketballClubById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        List<Player> players = playerService.findPlayerByBasketballClubId(uuid);
        if(players.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        else
            return playersToGetPlayersResponse.translate(players);
    }

    @DeleteMapping("/players/{uuid}")
    public void deletePlayer(@PathVariable UUID uuid){
        playerService.findPlayerById(uuid).ifPresentOrElse(player -> playerService.deletePlayerById(uuid),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }

    @PutMapping("/players/{uuid}")
    public void putPlayer(@PathVariable UUID uuid, @RequestBody PutPlayerRequest putPlayerRequest){
        if(playerService.findPlayerById(uuid).isPresent()){
            throw new ResponseStatusException(HttpStatus.FOUND);
        }
        else{
            basketballClubService.findBasketballClubById(putPlayerRequest.getBasketballClub()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
            );
            playerService.savePlayer(putPlayerRequestToPlayer.translate(uuid, putPlayerRequest));
        }
    }

    @PatchMapping("/players/{uuid}")
    public void updatePlayer(@PathVariable UUID uuid, @RequestBody PatchPlayerRequest patchPlayerRequest){
        Player player = playerService.findPlayerById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        player.setName(patchPlayerRequest.getName());
        player.setHeight(patchPlayerRequest.getHeight());
        playerService.savePlayer(player);
    }
}
