import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpSpringService } from '../http-spring.service';
@Component({
  selector: 'app-upload-pic',
  templateUrl: './upload-pic.component.html',
  styleUrls: ['./upload-pic.component.css']
})
export class UploadPicComponent implements OnInit {

  profilePic: any; //File

  constructor(private service: HttpSpringService,private router:Router) { }

  ngOnInit(): void {
  }

  handleFile(event) {
    this.profilePic = event.target.files[0];
  }

  upload() {
    let formData: FormData = new FormData();
    formData.append('userId', sessionStorage.getItem('userId'));
    formData.append('profilePic', this.profilePic);
    this.service.upload(formData).subscribe(status => {
     // alert(JSON.stringify(status));
      alert("Picture Upload "+JSON.stringify(status.status));
      this.router.navigate(["userprofile"]);
    })
  }



}
