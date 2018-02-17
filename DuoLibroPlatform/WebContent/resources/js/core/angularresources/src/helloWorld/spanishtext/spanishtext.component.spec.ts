import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpanishtextComponent } from './spanishtext.component';

describe('SpanishtextComponent', () => {
  let component: SpanishtextComponent;
  let fixture: ComponentFixture<HelloworldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpanishtextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpanishtextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
