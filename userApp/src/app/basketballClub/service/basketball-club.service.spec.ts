import { TestBed } from '@angular/core/testing';

import { BasketballClubService } from './basketball-club.service';

describe('BasketballClubService', () => {
  let service: BasketballClubService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BasketballClubService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
