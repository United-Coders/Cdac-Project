import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserhomelistComponent } from './userhomelist.component';

describe('UserhomelistComponent', () => {
  let component: UserhomelistComponent;
  let fixture: ComponentFixture<UserhomelistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserhomelistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserhomelistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
