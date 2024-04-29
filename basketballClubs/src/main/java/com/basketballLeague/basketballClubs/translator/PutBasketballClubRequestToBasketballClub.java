package com.basketballLeague.basketballClubs.translator;

import com.basketballLeague.basketballClubs.dto.PutBasketballClubRequest;
import com.basketballLeague.basketballClubs.entity.BasketballClub;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PutBasketballClubRequestToBasketballClub {
    public BasketballClub translate(UUID uuid, PutBasketballClubRequest putBasketballClubRequest){
        return BasketballClub.builder()
                .uuid(uuid)
                .name(putBasketballClubRequest.getName())
                .foundationYear(putBasketballClubRequest.getFoundationYear())
                .build();
    }
}
