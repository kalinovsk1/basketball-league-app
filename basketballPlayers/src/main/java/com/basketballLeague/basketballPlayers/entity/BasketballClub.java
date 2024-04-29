package com.basketballLeague.basketballPlayers.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "basketball_clubs")
public class BasketballClub implements Serializable {

    @Id
    private UUID uuid;

    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "basketballClub",cascade = CascadeType.ALL)
    private List<Player> players;

    @Override
    public String toString() {
        return "club id: " + this.uuid;
    }
}