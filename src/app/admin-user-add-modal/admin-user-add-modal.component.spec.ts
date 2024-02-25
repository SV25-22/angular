import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUserAddModalComponent } from './admin-user-add-modal.component';

describe('AdminUserAddModalComponent', () => {
  let component: AdminUserAddModalComponent;
  let fixture: ComponentFixture<AdminUserAddModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminUserAddModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminUserAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
