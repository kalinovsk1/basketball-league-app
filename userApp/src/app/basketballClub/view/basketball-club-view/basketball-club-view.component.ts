import {Component, OnInit} from '@angular/core';
import {BasketballClubService} from "../../service/basketball-club.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BasketballClubForm} from "../../model/basketballClubForm";
import {PlayerService} from "../../../player/service/player.service";
import {Players} from "../../../player/model/Players";
import {Player} from "../../../player/model/Player";

@Component({
  selector: 'app-basketball-club-view',
  templateUrl: './basketball-club-view.component.html',
  styleUrls: ['./basketball-club-view.component.css']
})
export class BasketballClubViewComponent implements OnInit{
  constructor(private basketballClubService: BasketballClubService,
              private playerService: PlayerService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  view_club: BasketballClubForm | undefined;
  view_players: Players | undefined;

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.basketballClubService.findBasketballClub(params['uuid'])
        .subscribe(club => this.view_club = {
          uuid: club.uuid,
          name: club.name,
          foundationYear: club.foundationYear
        });
      this.playerService.findPlayersFromClub(params['uuid'])
        .subscribe(players => this.view_players = players);
    });
  }

  OnPlayerDelete(player: Player): void{
    this.playerService.deletePlayer(player.uuid).subscribe(() => this.ngOnInit())
  }
}
