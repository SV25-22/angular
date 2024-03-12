import { Component, Inject, Injectable } from '@angular/core';
import { AdminNavBarComponent } from '../admin-nav-bar/admin-nav-bar.component';
import { CommonModule } from '@angular/common';
import { NgbModal, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { AddTemplateService } from '../add-template.service';


export class Input {
  label: string;
  type: string;
  shortcut: string;
  value: any;
  defaultValue: any;
  constructor(){
    this.label = "";
    this.type = "";
    this.shortcut = "";
    this.value = "";
    this.defaultValue = "";
  }
}

export class Template{
  name: string;
  inputs: Input[];
  constructor(){
    this.name = "";
    this.inputs = [];
  }
}


@Component({
  selector: 'app-add-template',
  standalone: true,
  imports: [AdminNavBarComponent,CommonModule,NgbModalModule,FormsModule],
  templateUrl: './add-template.component.html',
  styleUrl: './add-template.component.css'
})

export class AddTemplateComponent {
  templateToSave: Template = new Template();
  inputToEdit: Input = new Input();
  inputToAdd: Input = new Input();
  allInputs: Input[] = [];
  inputTypes: string[] = ["string","int","float","bool"]

  constructor(private modalService: NgbModal,private addTemplateService: AddTemplateService){

  }
  openAddInputModal(content: any){
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // save input
        this.allInputs.push(this.inputToAdd);
        console.log(this.inputToAdd);
        this.inputToAdd = new Input();
      },
      () => {
        // canceling
        this.inputToAdd = new Input();
      }
    );

  }

  saveTemplate(){
    //TODO check validation
    this.templateToSave.inputs = this.allInputs;
    this.addTemplateService.addTemplate(this.templateToSave).subscribe({
     next: () => {
      
      console.log("Saving template",this.templateToSave);
      this.templateToSave = new Template();

     },
     error: (error) =>{
      console.log(this.templateToSave);
      this.templateToSave = new Template();
     }
      

    }

    )
  }

  openSaveTemplateModal(content: any){
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // save template
        this.saveTemplate();
      },
      () => {
        // canceling
        this.templateToSave = new Template();
      }
    );

  }

  openResetTemplateModal(content: any){
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // reset template
        this.templateToSave = new Template();
        this.inputToAdd = new Input();
        this.allInputs = [];
      },
      () => {
        // canceling
        //nothing happens
      }
    );

  }
  openDeleteInputModal(content: any, input: any){
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // reset template
        const idx = this.allInputs.indexOf(input);
        this.allInputs.splice(idx,1);
      },
      () => {
        // canceling
        //nothing happens
      }
    );

  }

  openEditInputModal(content: any,input: any){
    this.inputToAdd = input;
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // save input
        const idx = this.allInputs.indexOf(input);
        this.allInputs[idx] = this.inputToAdd;
        this.inputToAdd = new Input();
      },
      () => {
        // canceling
        this.inputToAdd = new Input();
      }
    );

  }
}

