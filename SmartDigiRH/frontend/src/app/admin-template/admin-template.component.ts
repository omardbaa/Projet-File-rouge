import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-template',
  templateUrl: './admin-template.component.html',
  styleUrls: ['./admin-template.component.css']
})
export class AdminTemplateComponent implements OnInit {

  title = 'SmartDigiRH';
  logo:string="assets/Images/Logo.png";
 
  icon:string="assets/Images/SmartDigiRh.ico";

  constructor() { }

  ngOnInit(): void {
  }

}
