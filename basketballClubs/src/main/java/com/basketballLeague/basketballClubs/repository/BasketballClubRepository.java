package com.basketballLeague.basketballClubs.repository;

import com.basketballLeague.basketballClubs.entity.BasketballClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BasketballClubRepository extends JpaRepository<BasketballClub, UUID> {
    List<BasketballClub> findAll();
    BasketballClub save(BasketballClub entity);
    BasketballClub findBasketballClubByName(String name);
    @Override
    Optional<BasketballClub> findById(UUID uuid);
    @Override
    void deleteById(UUID uuid);
}
