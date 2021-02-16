import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrarianheaderComponent } from './librarianheader.component';

describe('LibrarianheaderComponent', () => {
  let component: LibrarianheaderComponent;
  let fixture: ComponentFixture<LibrarianheaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrarianheaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrarianheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
