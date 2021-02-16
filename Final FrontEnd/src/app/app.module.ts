import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxSpinnerModule } from "ngx-spinner";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { UserregisterComponent } from './userregister/userregister.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import {ReactiveFormsModule} from '@angular/forms';
import { UserhomeComponent } from './userhome/userhome.component';
import { ForgetComponent } from './forget/forget.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { LibregisterComponent } from './libregister/libregister.component';
import { LibloginComponent } from './liblogin/liblogin.component';
import { AdminregisterComponent } from './adminregister/adminregister.component';
import { LibrarianhomeComponent } from './librarianhome/librarianhome.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { SelectloginComponent } from './selectlogin/selectlogin.component';
import { EmailhomeComponent } from './emailhome/emailhome.component';
import { EmailtextComponent } from './emailtext/emailtext.component';
import { EmailattachmentComponent } from './emailattachment/emailattachment.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { ErrorComponent } from './error/error.component';
import { AdminheaderComponent } from './adminheader/adminheader.component';
import { UserheaderComponent } from './userheader/userheader.component';
import { LibrarianheaderComponent } from './librarianheader/librarianheader.component';
import { LogoutModalComponent } from './logout-modal/logout-modal.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FaqComponent } from './faq/faq.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { BookListComponent } from './book-list/book-list.component';
import { UpdateBooksComponent } from './update-books/update-books.component';
import { UserhomelistComponent } from './userhomelist/userhomelist.component';
import { AddtocartComponent } from './addtocart/addtocart.component';
import { PaymentComponent } from './payment/payment.component';
import { CounterComponent } from './counter/counter.component';
import { CommentComponent } from './comment/comment.component';
import { BooksDetailsComponent } from './books-details/books-details.component';
import { AdminprofileComponent } from './adminprofile/adminprofile.component';
import { LibrarianprofileComponent } from './librarianprofile/librarianprofile.component';
import { UploadPicComponent } from './upload-pic/upload-pic.component';
import { LiblistComponent } from './liblist/liblist.component';
import { UserlistComponent } from './userlist/userlist.component';
import { LibforgetComponent } from './libforget/libforget.component';
import { AdminforgetComponent } from './adminforget/adminforget.component';
import { PgresponseComponent } from './pgresponse/pgresponse.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    UserregisterComponent,
    UserhomeComponent,
    ForgetComponent,
    LibregisterComponent,
    LibloginComponent,
    AdminregisterComponent,
    LibrarianhomeComponent,
    AdminloginComponent,
    AdminhomeComponent,
    SelectloginComponent,
    EmailhomeComponent,
    EmailtextComponent,
    EmailattachmentComponent,
    UserprofileComponent,
    ErrorComponent,
    AdminheaderComponent,
    UserheaderComponent,
    LibrarianheaderComponent,
    LogoutModalComponent,
    AboutUsComponent,
    ContactUsComponent,
    FaqComponent,
    AddBooksComponent,
    BookListComponent,
    UpdateBooksComponent,
    UserhomelistComponent,
    AddtocartComponent,
    PaymentComponent,
    CounterComponent,
    CommentComponent,
    BooksDetailsComponent,
    AdminprofileComponent,
    LibrarianprofileComponent,
    UploadPicComponent,
    LiblistComponent,
    UserlistComponent,
    LibforgetComponent,
    AdminforgetComponent,
    PgresponseComponent,

   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    FontAwesomeModule,
    NgxSpinnerModule,
    Ng2SearchPipeModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
