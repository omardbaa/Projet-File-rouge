import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVacationComponent } from './update-vacation.component';

describe('UpdateVacationComponent', () => {
  let component: UpdateVacationComponent;
  let fixture: ComponentFixture<UpdateVacationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateVacationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateVacationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
