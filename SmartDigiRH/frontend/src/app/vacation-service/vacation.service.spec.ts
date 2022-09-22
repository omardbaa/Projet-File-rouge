import { TestBed } from '@angular/core/testing';

import { VacationService } from './vacation.service';

describe('VacationService', () => {
  let service: VacationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VacationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
