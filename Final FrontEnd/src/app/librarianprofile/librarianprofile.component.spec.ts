import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrarianprofileComponent } from './librarianprofile.component';

describe('LibrarianprofileComponent', () => {
  let component: LibrarianprofileComponent;
  let fixture: ComponentFixture<LibrarianprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrarianprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrarianprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
