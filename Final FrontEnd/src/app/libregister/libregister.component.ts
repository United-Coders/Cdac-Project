import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { LibrarianserviceService , Librarian , Message} from './../librarianservice.service';
import { FormControl, Validators, FormGroup } from '@angular/forms'
@Component({
  selector: 'app-libregister',
  templateUrl: './libregister.component.html',
  styleUrls: ['./libregister.component.css']
})
export class LibregisterComponent implements OnInit {

  librarian: Librarian = new Librarian( null,null ,null, null, null, null, null);

  public message: Message;
  public mssg: string = "";
  

  constructor(private librarianserviceService : LibrarianserviceService ) { }

  ngOnInit(): void {
  }

  public RegisterLibrarian1(obj: any) {
    this.librarianserviceService.RegisterLibrarian(obj).subscribe(res => {
      this.librarian.name = "";
      this.librarian.email = "";
      this.librarian.password = "";
      this.librarian.phone = "";
      this.librarian.licence_no = "";
      this.librarian.address = "";
      this.message = <Message>res;
      console.log(this.message.message);
      if (this.message.flag) {
        this.librarianserviceService.LoginLibrarianPage();
      }
      else {
        this.mssg = this.message.message;
      }

    });
  }


  public LoginLibrarian() {
    this.librarianserviceService.LoginLibrarianPage();
  }



  
  myFormGroup = new FormGroup({
    emailid: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.maxLength(50),
      Validators.pattern("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$")
    ]),
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(1),
      Validators.maxLength(20),
      Validators.pattern("[a-zA-Z]{1,20}")
    ]),

    address: new FormControl('', [
      Validators.required,
      Validators.minLength(1),
      Validators.maxLength(20),
      Validators.pattern("[a-zA-Z]{1,20}")
    ]),
   
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.maxLength(15),
      Validators.pattern('[a-zA-Z0-9@#%&+]+')      //^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$
    ]),
    phone: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(15),
      Validators.pattern("[0-9]{8,15}")
    ]),
    library_no: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(15),
      Validators.pattern("[0-9]{8,15}")
    ]),
  });

}
