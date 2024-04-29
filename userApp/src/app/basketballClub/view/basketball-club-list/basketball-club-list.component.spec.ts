import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasketballClubListComponent } from './basketball-club-list.component';

describe('BasketballClubListComponent', () => {
  let component: BasketballClubListComponent;
  let fixture: ComponentFixture<BasketballClubListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BasketballClubListComponent]
    });
    fixture = TestBed.createComponent(BasketballClubListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
