import { Component } from '@angular/core';
import { AdminNavBarComponent } from '../admin-nav-bar/admin-nav-bar.component';
//import  Template
@Component({
  selector: 'app-all-templates',
  standalone: true,
  imports: [AdminNavBarComponent],
  templateUrl: './all-templates.component.html',
  styleUrl: './all-templates.component.css'
})
export class AllTemplatesComponent {
  allTemplates: Template[] = [];
  constructor(private modalService: NgbModal){}
  
  oepnDeleteTemplateModal(content: any, template: any){
    this.modalService.open(content,{ariaLabelledBy: 'modal-basic-title'}).result.then(
      () => {
        // reset template
        const idx = this.allTemplates.indexOf(template);
        this.allTemplates.splice(idx,1);
      },
      () => {
        // canceling
        //nothing happens
      }
    );
  }

  openEditTemplateModal(content: any,template: any){
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      () => {
        // save input
        const idx = this.allTemplates.indexOf(template);
        this.allTemplates[idx] = template;
      },
      () => {
        // canceling
        //nothinghappens
      }
    );

  }

  openViewInputsModal(content:any,inputs:any){
    //TODO VIEW INPUTS
  }
}
