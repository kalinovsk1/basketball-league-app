import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainViewComponent} from "./main-view/main-view.component";
import {BasketballClubListComponent} from "./basketballClub/view/basketball-club-list/basketball-club-list.component";
import {BasketballClubNewComponent} from "./basketballClub/view/basketball-club-new/basketball-club-new.component";
import {BasketballClubEditComponent} from "./basketballClub/view/basketball-club-edit/basketball-club-edit.component";
import {BasketballClubViewComponent} from "./basketballClub/view/basketball-club-view/basketball-club-view.component";
import {PlayerNewComponent} from "./player/view/player-new/player-new.component";
import {PlayerEditComponent} from "./player/view/player-edit/player-edit.component";
import {PlayerViewComponent} from "./player/view/player-view/player-view.component";

const routes: Routes = [
  {
    component: MainViewComponent,
    path: ""
  },
  {
    component: BasketballClubListComponent,
    path: "basketballClubs"
  },
  {
    component: BasketballClubNewComponent,
    path: "basketballClubs/new"
  },
  {
    component: BasketballClubEditComponent,
    path: "basketballClubs/:uuid/edit"
  },
  {
    component: BasketballClubViewComponent,
    path: "basketballClubs/:uuid"
  },
  {
    component: PlayerNewComponent,
    path: "basketballClubs/:uuid/newPlayer"
  },
  {
    component: PlayerEditComponent,
    path: "basketballClubs/:uuid/editPlayer/:uuid_player"
  },
  {
    component: PlayerViewComponent,
    path: "basketballClubs/:uuid/viewPlayer/:uuid_player"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
