import { Component, OnInit } from '@angular/core';
import { User } from '../login/login.component';
import { CurrentUserService } from '../current-user.service';
import { CommonModule, NgIf,NgFor } from '@angular/common';
import { AdminNavBarComponent } from '../admin-nav-bar/admin-nav-bar.component';
import { NgbModal, NgbModalModule, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { GetUsersService } from '../get-users.service';
import { CreateUserService } from '../create-user.service';
import { EditUserService } from '../edit-user.service';
import { DeleteUserService } from '../delete-user.service';
@Component({
  selector: 'app-admin-users',
  standalone: true,
  imports: [CommonModule,AdminNavBarComponent,NgbModalModule,FormsModule],
  templateUrl: './admin-users.component.html',
  styleUrl: './admin-users.component.css'
})

export class AdminUsersComponent implements OnInit{
  user: User;
  isDeleteModalVisible: boolean = false;
  userToEdit: any = new User();
  userToAdd: User = new User();

  usersMap: Map<string, User> = new Map<string, User>();

  constructor(private currentUserService: CurrentUserService, private modalService: NgbModal,private getUsersService: GetUsersService,private addUserService: CreateUserService, private editUserService: EditUserService, private deleteUserService: DeleteUserService) {
    this.user = this.currentUserService.getCurrentUser();
    this.getUsersService.getUsers().subscribe({
      next: (usersMap) => {
        this.usersMap = usersMap;
        //console.log(this.usersMap)
      },
      error: (error) =>{
        console.log(this.usersMap)
      }
  
    })
  }
  
  getUsersArray(): User[]{
    return Array.from(this.usersMap.values());
  }
  ngOnInit(): void {
    this.user = this.currentUserService.getCurrentUser();
  }
  deleteUser(user: any,content: any){
    this.userToEdit = user;
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
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
    this.userToEdit = new User();
  }

  //HERE GOES DEL CALL
  confirmDelete(){

    this.deleteUserService.deleteUser(this.userToEdit.username).subscribe(
      response => {
        console.log("Deleting user",this.userToEdit)
        this.usersMap.delete(this.userToEdit.username);
        this.userToEdit = new User();
      },
      error => {
        console.error("Error deleting user: ",error);
      }
    )
  }

  openAddUserModal(content: any) {
    //this.userToAdd = new User();
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // saving
        this.saveUser();
      },
      () => {
        // canceling
        this.cancelAddUser();
      }
    );
  }
  saveUser() {
    // TODO check validation
    this.addUserService.addUser(this.userToAdd).subscribe({
      next: () => {
        console.log("Saving user", this.userToAdd);
        this.usersMap.set(this.userToAdd.username,this.userToAdd);
        this.userToAdd = new User();
      },
      error: (error) =>{
        console.log(this.userToAdd);
        this.userToAdd = new User();
      }
  
    })
  }
  cancelAddUser() {
    this.userToAdd = new User();
  }

  openEditUserModal(user: User, content: any,oldUserName: string) {
    this.userToEdit = { ...user }; // Create a copy of the user to avoid modifying the original
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // saving
        this.saveEdit(oldUserName);
      },
      () => {
        // canceling
        this.cancelEditUser();
      }
    );
  }


  
  saveEdit(oldUserName: string){
    //TODO validation
    this.editUserService.editUser(oldUserName,this.userToEdit).subscribe({
      next: () =>{
        console.log("Editing user", this.userToEdit);
        this.usersMap.delete(oldUserName);
        this.usersMap.set(this.userToEdit.username, this.userToEdit);
      },
      error: (error) =>{
        console.log(this.userToEdit);
        this.userToEdit = new User();
      }
    })



  }

  cancelEditUser() {
    this.userToEdit = new User();
  }

}
