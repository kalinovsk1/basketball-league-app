package com.basketballLeague.basketballPlayers.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player implements Comparable<Player>, Serializable {

    @Id
    private UUID uuid;

    @Column(name="player_name")
    private String name;

    @Column(name="player_height")
    private int height;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basketball_club")
    private BasketballClub basketballClub;

    @Override
    public int compareTo(Player other) {
        int ret = this.name.compareTo(other.name);
        if(ret == 0){
            return this.height - other.height;
        }
        return ret;
    }

    @Override
    public String toString() {
        return "id: " + this.uuid + "  name: " + this.name + "   height: " + this.height;
    }
}