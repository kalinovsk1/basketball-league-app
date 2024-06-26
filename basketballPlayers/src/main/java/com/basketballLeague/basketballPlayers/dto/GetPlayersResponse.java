package com.basketballLeague.basketballPlayers.dto;

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
public class GetPlayersResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Player{
        private UUID uuid;
        private String name;
    }
    @Singular
    private List<Player> players;
}
