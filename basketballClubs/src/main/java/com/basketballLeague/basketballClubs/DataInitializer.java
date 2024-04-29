package com.basketballLeague.basketballClubs;

import com.basketballLeague.basketballClubs.entity.BasketballClub;
import com.basketballLeague.basketballClubs.service.BasketballClubService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    private BasketballClubService basketballClubService;

    @Autowired
    public DataInitializer(BasketballClubService basketballClubService){
        this.basketballClubService = basketballClubService;
    }

    @PostConstruct
    public void init() throws Exception{
        UUID uuid1 = UUID.fromString("356eddaa-cb68-41a6-bf4b-5f75bd2c146e");
        UUID uuid2 = UUID.fromString("5f17dd93-c7b6-4d8b-bd34-b07728f7c66f");
        UUID uuid3 = UUID.fromString("6ff60db2-5a7f-429a-b5df-cc2507bdec3f");

        BasketballClub club1 = new BasketballClub();
        club1.setUuid(uuid1);
        club1.setName("Chicago Bulls");
        club1.setFoundationYear(1966);
        basketballClubService.saveBasketballClub(club1);

        BasketballClub club2 = new BasketballClub();
        club2.setUuid(uuid2);
        club2.setName("Los Angeles Lakers");
        club2.setFoundationYear(1947);
        basketballClubService.saveBasketballClub(club2);

        BasketballClub club3 = new BasketballClub();
        club3.setUuid(uuid3);
        club3.setName("Golden State Warriors");
        club3.setFoundationYear(1946);
        basketballClubService.saveBasketballClub(club3);

        basketballClubService.findAllBasketballClubs().forEach(System.out::println);
        System.out.println();
    }
}
