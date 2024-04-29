package com.basketballLeague.basketballPlayers.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PatchPlayerRequest {
    private String name;
    private int height;
}
