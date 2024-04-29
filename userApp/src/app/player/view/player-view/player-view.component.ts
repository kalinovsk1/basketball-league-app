import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerForm} from "../../model/PlayerForm";

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit{
  constructor(private playerService: PlayerService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  view_player: PlayerForm | undefined;

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.playerService.findPlayer(params['uuid_player']).subscribe(player =>
        this.view_player = {
          uuid: player.uuid,
          name: player.name,
          height: player.height,
          basketballClub: player.basketballClub
        });
    });
  }
}
