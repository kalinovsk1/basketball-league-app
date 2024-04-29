import { Component } from '@angular/core';
import {BasketballClubService} from "../../service/basketball-club.service";
import {Router} from "@angular/router";
import {BasketballClubForm} from "../../model/basketballClubForm";

@Component({
  selector: 'app-basketball-club-new',
  templateUrl: './basketball-club-new.component.html',
  styleUrls: ['./basketball-club-new.component.css']
})
export class BasketballClubNewComponent{
  constructor(private basketballClubService: BasketballClubService,
              private router: Router) {
  }

  new_club: BasketballClubForm = {uuid:"", name:"", foundationYear:0}

  OnBasketballClubAdd(): void{
    this.basketballClubService.addNewBasketballClub(this.new_club.uuid, this.new_club).subscribe(() => this.router.navigate(['/basketballClubs']))
  }
}
