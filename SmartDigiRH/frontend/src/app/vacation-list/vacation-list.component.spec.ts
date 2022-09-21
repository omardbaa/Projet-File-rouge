import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VacationListComponent } from './vacation-list.component';

describe('VacationListComponent', () => {
  let component: VacationListComponent;
  let fixture: ComponentFixture<VacationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VacationListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VacationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
