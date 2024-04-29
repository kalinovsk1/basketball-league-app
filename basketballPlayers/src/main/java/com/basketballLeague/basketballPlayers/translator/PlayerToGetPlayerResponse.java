package com.basketballLeague.basketballPlayers.translator;

import com.basketballLeague.basketballPlayers.dto.GetPlayerResponse;
import com.basketballLeague.basketballPlayers.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerToGetPlayerResponse {
    public GetPlayerResponse translate(Player player){
        return GetPlayerResponse.builder()
                .uuid(player.getUuid())
                .name(player.getName())
                .height(player.getHeight())
                .basketballClub(GetPlayerResponse.BasketballClub.builder()
                        .uuid(player.getBasketballClub().getUuid())
                        .build()).build();
    }
}
