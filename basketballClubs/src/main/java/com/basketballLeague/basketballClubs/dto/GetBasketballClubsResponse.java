package com.basketballLeague.basketballClubs.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetBasketballClubsResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class BasketballClub{
        private UUID uuid;
        private String name;
    }
    @Singular
    List<BasketballClub> basketballClubs;
}
