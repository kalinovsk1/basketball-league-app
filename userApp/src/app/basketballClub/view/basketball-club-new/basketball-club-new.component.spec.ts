import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasketballClubNewComponent } from './basketball-club-new.component';

describe('BasketballClubNewComponent', () => {
  let component: BasketballClubNewComponent;
  let fixture: ComponentFixture<BasketballClubNewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BasketballClubNewComponent]
    });
    fixture = TestBed.createComponent(BasketballClubNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
