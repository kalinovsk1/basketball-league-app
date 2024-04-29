package com.basketballLeague.basketballClubs.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PatchBasketballClubRequest {
    private String name;
    private int foundationYear;
}
