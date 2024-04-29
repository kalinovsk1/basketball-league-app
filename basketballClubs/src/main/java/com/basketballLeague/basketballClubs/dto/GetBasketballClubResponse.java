package com.basketballLeague.basketballClubs.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetBasketballClubResponse {
    private UUID uuid;
    private String name;
    private int foundationYear;
}
