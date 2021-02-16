import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibforgetComponent } from './libforget.component';

describe('LibforgetComponent', () => {
  let component: LibforgetComponent;
  let fixture: ComponentFixture<LibforgetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibforgetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibforgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
