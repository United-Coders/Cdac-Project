import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailtextComponent } from './emailtext.component';

describe('EmailtextComponent', () => {
  let component: EmailtextComponent;
  let fixture: ComponentFixture<EmailtextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmailtextComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmailtextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
