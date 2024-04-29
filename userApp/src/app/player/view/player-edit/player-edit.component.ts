import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerForm} from "../../model/PlayerForm";

@Component({
  selector: 'app-player-edit',
  templateUrl: './player-edit.component.html',
  styleUrls: ['./player-edit.component.css']
})
export class PlayerEditComponent implements OnInit{
  constructor(private playerService: PlayerService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  edit_player: PlayerForm | undefined;
  club_uuid: string | undefined

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.club_uuid = params['uuid']
      this.playerService.findPlayer(params['uuid_player'])
        .subscribe(player => {
          this.edit_player = {
            uuid: player.uuid,
            name: player.name,
            height: player.height,
            basketballClub: player.basketballClub
          };
        });
    });
  }

  OnPlayerEdit(): void{
    this.playerService.editPlayer(this.edit_player!.uuid, this.edit_player!)
      .subscribe(() => this.router.navigate(['/basketballClubs/' + this.club_uuid]));
  }

}
