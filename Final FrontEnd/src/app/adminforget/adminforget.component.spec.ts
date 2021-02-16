import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminforgetComponent } from './adminforget.component';

describe('AdminforgetComponent', () => {
  let component: AdminforgetComponent;
  let fixture: ComponentFixture<AdminforgetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminforgetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminforgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
