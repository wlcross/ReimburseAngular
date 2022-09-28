import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerRequestListComponent } from './manager-request-list.component';

describe('ManagerRequestListComponent', () => {
  let component: ManagerRequestListComponent;
  let fixture: ComponentFixture<ManagerRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerRequestListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManagerRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
