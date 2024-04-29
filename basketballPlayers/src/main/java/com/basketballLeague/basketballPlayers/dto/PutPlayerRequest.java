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
public class PutPlayerRequest {
    private String name;
    private int height;
    private UUID basketballClub;
}
