package com.basketballLeague.basketballPlayers;

import com.basketballLeague.basketballPlayers.entity.BasketballClub;
import com.basketballLeague.basketballPlayers.entity.Player;
import com.basketballLeague.basketballPlayers.service.BasketballClubService;
import com.basketballLeague.basketballPlayers.service.PlayerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class DataInitializer {
    private PlayerService playerService;
    private BasketballClubService basketballClubService;

    @Autowired
    public DataInitializer(PlayerService playerService, BasketballClubService basketballClubService){
        this.playerService = playerService;
        this.basketballClubService = basketballClubService;
    }

    @PostConstruct
    public void init() throws Exception{
        BasketballClub club1 = new BasketballClub();
        club1.setUuid(UUID.fromString("356eddaa-cb68-41a6-bf4b-5f75bd2c146e"));
        club1.setPlayers(new ArrayList<>());
        basketballClubService.saveBasketballClub(club1);

        BasketballClub club2 = new BasketballClub();
        club2.setUuid(UUID.fromString("5f17dd93-c7b6-4d8b-bd34-b07728f7c66f"));
        club2.setPlayers(new ArrayList<>());
        basketballClubService.saveBasketballClub(club2);

        BasketballClub club3 = new BasketballClub();
        club3.setUuid(UUID.fromString("6ff60db2-5a7f-429a-b5df-cc2507bdec3f"));
        club3.setPlayers(new ArrayList<>());
        basketballClubService.saveBasketballClub(club3);

        Player player1 = new Player();
        player1.setUuid(UUID.fromString("5d4802ee-8a7f-47f4-aedd-c363f3eeddd2"));
        player1.setName("Zach LaVine");
        player1.setHeight(195);
        player1.setBasketballClub(club1);
        playerService.savePlayer(player1);

        Player player2 = new Player();
        player2.setUuid(UUID.fromString("44912b1d-a11a-49df-9d5c-8f81ced82cf8"));
        player2.setName("DeMar DeRozan");
        player2.setHeight(190);
        player2.setBasketballClub(club1);
        playerService.savePlayer(player2);

        Player player3 = new Player();
        player3.setUuid(UUID.fromString("3edc20ee-4bf0-404c-9ea9-1b744a7560b8"));
        player3.setName("Lebron James");
        player3.setHeight(200);
        player3.setBasketballClub(club2);
        playerService.savePlayer(player3);

        Player player4 = new Player();
        player4.setUuid(UUID.fromString("4ed86695-65e8-461b-bb18-79badd15d2be"));
        player4.setName("Russell Westbrook");
        player4.setHeight(185);
        player4.setBasketballClub(club2);
        playerService.savePlayer(player4);

        Player player5 = new Player();
        player5.setUuid(UUID.fromString("1c30d8ab-1159-41f1-892b-ab032f0a591c"));
        player5.setName("Stephen Curry");
        player5.setHeight(190);
        player5.setBasketballClub(club3);
        playerService.savePlayer(player5);

        Player player6 = new Player();
        player6.setUuid(UUID.fromString("02ff0198-4c94-4708-a7d9-04d07b192395"));
        player6.setName("Draymond Green");
        player6.setHeight(205);
        player6.setBasketballClub(club3);
        playerService.savePlayer(player6);

        playerService.findAllPlayers().forEach(System.out::println);
    }
}
