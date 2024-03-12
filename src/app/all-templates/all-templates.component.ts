import { Component } from '@angular/core';
import { AdminNavBarComponent } from '../admin-nav-bar/admin-nav-bar.component';

@Component({
  selector: 'app-all-templates',
  standalone: true,
  imports: [AdminNavBarComponent],
  templateUrl: './all-templates.component.html',
  styleUrl: './all-templates.component.css'
})
export class AllTemplatesComponent {

}
