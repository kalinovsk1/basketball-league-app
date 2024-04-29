package com.basketballLeague.basketballPlayers.repository;

import com.basketballLeague.basketballPlayers.entity.BasketballClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BasketballClubRepository extends JpaRepository<BasketballClub, UUID> {
    BasketballClub save(BasketballClub entity);
    @Override
    Optional<BasketballClub> findById(UUID uuid);
    @Override
    void deleteById(UUID uuid);
}
