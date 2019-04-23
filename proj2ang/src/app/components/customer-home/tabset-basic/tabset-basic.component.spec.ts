import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabsetBasicComponent } from './tabset-basic.component';

describe('TabsetBasicComponent', () => {
  let component: TabsetBasicComponent;
  let fixture: ComponentFixture<TabsetBasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabsetBasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabsetBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
