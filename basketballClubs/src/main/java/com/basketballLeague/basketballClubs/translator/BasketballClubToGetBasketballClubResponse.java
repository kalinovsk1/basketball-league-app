package com.basketballLeague.basketballClubs.translator;

import com.basketballLeague.basketballClubs.dto.GetBasketballClubResponse;
import com.basketballLeague.basketballClubs.entity.BasketballClub;
import org.springframework.stereotype.Component;

@Component
public class BasketballClubToGetBasketballClubResponse {
    public GetBasketballClubResponse translate(BasketballClub basketballClub){
        return GetBasketballClubResponse.builder()
                .uuid(basketballClub.getUuid())
                .name(basketballClub.getName())
                .foundationYear(basketballClub.getFoundationYear())
                .build();
    }
}