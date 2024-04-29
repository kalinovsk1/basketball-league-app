package com.basketballLeague.basketballPlayers.translator;

import com.basketballLeague.basketballPlayers.dto.GetPlayersResponse;
import com.basketballLeague.basketballPlayers.entity.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayersToGetPlayersResponse {
    public GetPlayersResponse translate(List<Player> players){
        return GetPlayersResponse.builder()
                .players(players.stream()
                        .map(player -> GetPlayersResponse.Player.builder()
                                .uuid(player.getUuid())
                                .name(player.getName())
                                .build())
                        .toList())
                .build();
    }
}
