import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  comment = "";
  postComment = [];
  post(){
   this.postComment.push(this.comment);
   this.comment = "";
  }

remove(cmt){
  this.postComment.splice(cmt,1);
}
  reset(){
    
    this.comment = "";
   }
  constructor() { }

  ngOnInit(): void {
  }

}
