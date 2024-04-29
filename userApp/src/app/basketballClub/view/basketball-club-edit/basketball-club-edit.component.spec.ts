import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasketballClubEditComponent } from './basketball-club-edit.component';

describe('BasketballClubEditComponent', () => {
  let component: BasketballClubEditComponent;
  let fixture: ComponentFixture<BasketballClubEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BasketballClubEditComponent]
    });
    fixture = TestBed.createComponent(BasketballClubEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
