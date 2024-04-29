package com.basketballLeague.basketballPlayers.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetPlayerResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class BasketballClub{
        private UUID uuid;
    }
    private UUID uuid;
    private String name;
    private int height;
    private BasketballClub basketballClub;
}
