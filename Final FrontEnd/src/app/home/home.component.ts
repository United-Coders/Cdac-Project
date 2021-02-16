import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl ,Validators} from '@angular/forms';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

 

  loginform = new FormGroup({
    username : new FormControl('',[
      Validators.required])
     
    }); 
    
  constructor() { }

  ngOnInit(): void {
    
  
      
  
  
  

}
}



