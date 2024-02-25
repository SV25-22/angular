import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUserEditModalComponent } from './admin-user-edit-modal.component';

describe('AdminUserEditModalComponent', () => {
  let component: AdminUserEditModalComponent;
  let fixture: ComponentFixture<AdminUserEditModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminUserEditModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminUserEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
