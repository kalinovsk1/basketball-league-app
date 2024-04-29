import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BasketballClubEditComponent } from './basketballClub/view/basketball-club-edit/basketball-club-edit.component';
import { BasketballClubListComponent } from './basketballClub/view/basketball-club-list/basketball-club-list.component';
import { BasketballClubNewComponent } from './basketballClub/view/basketball-club-new/basketball-club-new.component';
import { BasketballClubViewComponent } from './basketballClub/view/basketball-club-view/basketball-club-view.component';
import { MainViewComponent } from './main-view/main-view.component';
import { PlayerEditComponent } from './player/view/player-edit/player-edit.component';
import { PlayerNewComponent } from './player/view/player-new/player-new.component';
import { PlayerViewComponent } from './player/view/player-view/player-view.component';
import {BasketballClubService} from "./basketballClub/service/basketball-club.service";
import {PlayerService} from "./player/service/player.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    BasketballClubEditComponent,
    BasketballClubListComponent,
    BasketballClubNewComponent,
    BasketballClubViewComponent,
    MainViewComponent,
    PlayerEditComponent,
    PlayerNewComponent,
    PlayerViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BasketballClubService, PlayerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
