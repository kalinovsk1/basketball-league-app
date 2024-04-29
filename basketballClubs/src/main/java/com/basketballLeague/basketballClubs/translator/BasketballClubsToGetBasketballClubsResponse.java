package com.basketballLeague.basketballClubs.translator;

import com.basketballLeague.basketballClubs.dto.GetBasketballClubsResponse;
import com.basketballLeague.basketballClubs.entity.BasketballClub;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasketballClubsToGetBasketballClubsResponse {
    public GetBasketballClubsResponse translate(List<BasketballClub> basketballClubs){
        return GetBasketballClubsResponse.builder()
                .basketballClubs(basketballClubs.stream()
                        .map(basketballClub -> GetBasketballClubsResponse.BasketballClub.builder()
                                .uuid(basketballClub.getUuid())
                                .name(basketballClub.getName())
                                .build())
                        .toList())
                .build();
    }
}
