import { TestBed } from '@angular/core/testing';

import { HttpSpringService } from './http-spring.service';

describe('HttpSpringService', () => {
  let service: HttpSpringService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpSpringService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
