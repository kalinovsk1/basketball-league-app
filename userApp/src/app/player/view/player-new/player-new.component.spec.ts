import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerNewComponent } from './player-new.component';

describe('PlayerNewComponent', () => {
  let component: PlayerNewComponent;
  let fixture: ComponentFixture<PlayerNewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlayerNewComponent]
    });
    fixture = TestBed.createComponent(PlayerNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
