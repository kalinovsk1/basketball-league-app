package com.basketballLeague.basketballPlayers.repository;

import com.basketballLeague.basketballPlayers.entity.Player;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, UUID> {
    List<Player> findAll();
    Player save(Player entity);
    @Override
    Optional<Player> findById(UUID uuid);
    List<Player> findByBasketballClub_Uuid(UUID uuid);
    @Transactional
    void deletePlayerByName(String name);
    @Override
    void deleteById(UUID uuid);
}
