package com.basketballLeague.basketballPlayers.translator;

import com.basketballLeague.basketballPlayers.dto.PutPlayerRequest;
import com.basketballLeague.basketballPlayers.entity.BasketballClub;
import com.basketballLeague.basketballPlayers.entity.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PutPlayerRequestToPlayer {
    public Player translate(UUID uuid, PutPlayerRequest putPlayerRequest){
        return Player.builder()
                .uuid(uuid)
                .name(putPlayerRequest.getName())
                .height(putPlayerRequest.getHeight())
                .basketballClub(BasketballClub.builder().uuid(putPlayerRequest.getBasketballClub()).build())
                .build();
    }
}
