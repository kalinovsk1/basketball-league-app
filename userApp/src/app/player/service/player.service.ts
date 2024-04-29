import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Players} from "../model/Players";
import {Observable} from "rxjs";
import {PlayerForm} from "../model/PlayerForm";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) {
  }

  findAllPlayers(): Observable<Players>{
    return this.http.get<Players>('/basketballLeague/players');
  }

  findPlayer(uuid: string): Observable<PlayerForm>{
    return this.http.get<PlayerForm>('basketballLeague/players/' + uuid)
  }

  findPlayersFromClub(uuid: string): Observable<Players>{
    return this.http.get<Players>('/basketballLeague/clubs/' + uuid + '/players');
  }

  editPlayer(uuid: string, edit_player: PlayerForm): Observable<any>{
    return this.http.patch('/basketballLeague/players/' + uuid, edit_player);
  }

  deletePlayer(uuid: string): Observable<any>{
    return this.http.delete('/basketballLeague/players/' + uuid);
  }

  addNewPlayer(uuid: string, new_player: PlayerForm): Observable<any>{
    return this.http.put('/basketballLeague/players/' + uuid, new_player);
  }
}
