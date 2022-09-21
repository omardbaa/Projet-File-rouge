import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateVacationComponent } from './create-vacation.component';

describe('CreateVacationComponent', () => {
  let component: CreateVacationComponent;
  let fixture: ComponentFixture<CreateVacationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateVacationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateVacationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
