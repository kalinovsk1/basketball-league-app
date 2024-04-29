package com.basketballLeague.basketballClubs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "basketball_clubs")
public class BasketballClub implements Comparable<BasketballClub>, Serializable {

    @Id
    private UUID uuid;

    @Column(name="basketballclub_name")
    private String name;

    @Column(name="foundation_year")
    private int foundationYear;

    @Override
    public int compareTo(BasketballClub other) {
        int ret = this.name.compareTo(other.name);
        if(ret == 0){
            return this.foundationYear - other.foundationYear;
        }
        return ret;
    }

    @Override
    public String toString() {
        return "id: " + this.uuid + "  name: " + this.name + "   Year of foundation: " + this.foundationYear;
    }
}
