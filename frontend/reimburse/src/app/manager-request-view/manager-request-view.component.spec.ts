import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerRequestViewComponent } from './manager-request-view.component';

describe('ManagerRequestViewComponent', () => {
  let component: ManagerRequestViewComponent;
  let fixture: ComponentFixture<ManagerRequestViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerRequestViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManagerRequestViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
