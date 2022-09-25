import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeSpaceComponent } from './employee-space.component';

describe('EmployeeSpaceComponent', () => {
  let component: EmployeeSpaceComponent;
  let fixture: ComponentFixture<EmployeeSpaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeSpaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeeSpaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
