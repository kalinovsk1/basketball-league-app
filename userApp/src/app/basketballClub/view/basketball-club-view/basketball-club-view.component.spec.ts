import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasketballClubViewComponent } from './basketball-club-view.component';

describe('BasketballClubViewComponent', () => {
  let component: BasketballClubViewComponent;
  let fixture: ComponentFixture<BasketballClubViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BasketballClubViewComponent]
    });
    fixture = TestBed.createComponent(BasketballClubViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
