import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LiblistComponent } from './liblist.component';

describe('LiblistComponent', () => {
  let component: LiblistComponent;
  let fixture: ComponentFixture<LiblistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LiblistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LiblistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
