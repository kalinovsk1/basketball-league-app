import { Component } from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerForm} from "../../model/PlayerForm";

@Component({
  selector: 'app-player-new',
  templateUrl: './player-new.component.html',
  styleUrls: ['./player-new.component.css']
})
export class PlayerNewComponent {
  constructor(private playerService: PlayerService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  new_player: PlayerForm = {uuid:"", name:"", height:0, basketballClub:""}

  OnPlayerAdd(): void{
    this.route.params.subscribe(params =>{
      this.new_player.basketballClub = params['uuid']
    })
    this.playerService.addNewPlayer(this.new_player.uuid, this.new_player)
      .subscribe(() => this.router.navigate(['/basketballClubs/' + this.new_player.basketballClub]));
  }
}
