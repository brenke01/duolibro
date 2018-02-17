import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintextComponent } from './maintext.component';

describe('MaintextComponent', () => {
  let component: MaintextComponent;
  let fixture: ComponentFixture<HelloworldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaintextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaintextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
