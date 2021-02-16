import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailhomeComponent } from './emailhome.component';

describe('EmailhomeComponent', () => {
  let component: EmailhomeComponent;
  let fixture: ComponentFixture<EmailhomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmailhomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmailhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
