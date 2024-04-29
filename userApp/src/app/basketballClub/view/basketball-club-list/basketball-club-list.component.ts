import {Component, OnInit} from '@angular/core';
import {BasketballClubService} from "../../service/basketball-club.service";
import {BasketballClubs} from "../../model/basketballClubs";
import {BasketballClub} from "../../model/basketballClub";

@Component({
  selector: 'app-basketball-club-list',
  templateUrl: './basketball-club-list.component.html',
  styleUrls: ['./basketball-club-list.component.css']
})
export class BasketballClubListComponent implements OnInit{
  constructor(private basketballClubService: BasketballClubService) {
  }

  clubs: BasketballClubs | undefined
  ngOnInit(): void {
    this.basketballClubService.findAllBasketballClubs().subscribe(clubs => this.clubs = clubs);
  }

  OnBasketballClubDelete(basketballClub: BasketballClub): void{
    this.basketballClubService.deleteBasketballClub(basketballClub.uuid).subscribe(() => this.ngOnInit())
  }
}
