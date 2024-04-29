import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BasketballClubs} from "../model/basketballClubs";
import {Observable} from "rxjs";
import {BasketballClubForm} from "../model/basketballClubForm";

@Injectable({
  providedIn: 'root'
})
export class BasketballClubService {

  constructor(private http: HttpClient) {
  }

  findAllBasketballClubs(): Observable<BasketballClubs>{
    return this.http.get<BasketballClubs>('/basketballLeague/clubs');
  }

  findBasketballClub(uuid: string): Observable<BasketballClubForm>{
    return this.http.get<BasketballClubForm>('/basketballLeague/clubs/' + uuid)
  }

  deleteBasketballClub(uuid: string): Observable<any>{
    return this.http.delete('/basketballLeague/clubs/' + uuid);
  }

  addNewBasketballClub(uuid: string, new_club: BasketballClubForm): Observable<any>{
    return this.http.put('/basketballLeague/clubs/' + uuid, new_club);
  }

  editBasketballClub(uuid: string, edit_club: BasketballClubForm): Observable<any>{
    return this.http.patch('basketballLeague/clubs/' + uuid, edit_club)
  }
}
