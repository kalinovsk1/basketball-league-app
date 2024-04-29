package com.basketballLeague.basketballClubs.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PutBasketballClubRequest {
    private String name;
    private int foundationYear;
}
