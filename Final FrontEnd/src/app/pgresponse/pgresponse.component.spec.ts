import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PgresponseComponent } from './pgresponse.component';

describe('PgresponseComponent', () => {
  let component: PgresponseComponent;
  let fixture: ComponentFixture<PgresponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PgresponseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PgresponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
