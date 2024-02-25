import { Component, OnInit } from '@angular/core';
import { User } from '../login/login.component';
import { CurrentUserService } from '../current-user.service';
import { CommonModule, NgIf,NgFor } from '@angular/common';
import { AdminNavBarComponent } from '../admin-nav-bar/admin-nav-bar.component';
import { NgbModal, NgbModalModule, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-admin-users',
  standalone: true,
  imports: [CommonModule,NgIf,NgFor,AdminNavBarComponent,NgbModalModule],
  templateUrl: './admin-users.component.html',
  styleUrl: './admin-users.component.css'
})

export class AdminUsersComponent implements OnInit{
  user: User;
  isDeleteModalVisible: boolean = false;
  userToEdit: any = null;
  constructor(private currentUserService: CurrentUserService, private deleteModalService: NgbModal) {
    this.user = this.currentUserService.getCurrentUser();
  }
  dummyUsers: User[] = [
    new User("John", "Doe", "username1", "password1", false),
    new User("Jane", "Doe", "username2", "password2", false),
    new User("Admin", "Admin", "admin", "admin123", true),
    new User("Jane", "Doe", "username2", "password2", false),
    new User("Admin", "Admin", "admin", "admin123", true),
    new User("Jane", "Doe", "username2", "password2", false),
    new User("Admin", "Admin", "admin", "admin123", true)
  ];



  ngOnInit(): void {
    this.user = this.currentUserService.getCurrentUser();
  }
  addUser(){
    console.log("Adding user")
  }
  editUser(user:any){
    console.log(user.name)
  }
  deleteUser(user: any,content: any){
    this.userToEdit = user;
    this.deleteModalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // User confirmed deletion
        this.confirmDelete();
      },
      () => {
        // User canceled deletion
        this.cancelDelete();
      }
    );
  }

  cancelDelete(){
    this.userToEdit = null;
  }
  confirmDelete(){
    console.log("Deleting user",this.userToEdit)
    this.userToEdit = null;
  }

}
