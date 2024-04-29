import {Component, OnInit} from '@angular/core';
import {BasketballClubService} from "../../service/basketball-club.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BasketballClubForm} from "../../model/basketballClubForm";

@Component({
  selector: 'app-basketball-club-edit',
  templateUrl: './basketball-club-edit.component.html',
  styleUrls: ['./basketball-club-edit.component.css']
})
export class BasketballClubEditComponent implements OnInit{
  constructor(private basketballClubService: BasketballClubService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  edit_club: BasketballClubForm | undefined;

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.basketballClubService.findBasketballClub(params['uuid'])
        .subscribe(club => {
          this.edit_club = {
            uuid: club.uuid, name: club.name, foundationYear: club.foundationYear
          };
        });
    });
  }

  OnBasketballClubEdit(): void{
    this.basketballClubService.editBasketballClub(this.edit_club!.uuid, this.edit_club!).subscribe(() => this.router.navigate(['/basketballClubs']));
  }
}
