import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddtocartComponent } from './addtocart/addtocart.component';
import { AdminforgetComponent } from './adminforget/adminforget.component';
import { AdminheaderComponent } from './adminheader/adminheader.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminprofileComponent } from './adminprofile/adminprofile.component';
import { AdminregisterComponent } from './adminregister/adminregister.component';
import { BookListComponent } from './book-list/book-list.component';
import { BooksDetailsComponent } from './books-details/books-details.component';
import { CommentComponent } from './comment/comment.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { EmailattachmentComponent } from './emailattachment/emailattachment.component';
import { EmailhomeComponent } from './emailhome/emailhome.component';
import { EmailtextComponent } from './emailtext/emailtext.component';
import { ErrorComponent } from './error/error.component';
import { FaqComponent } from './faq/faq.component';
import { FooterComponent } from './footer/footer.component';
import { ForgetComponent } from './forget/forget.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LibforgetComponent } from './libforget/libforget.component';
import { LiblistComponent } from './liblist/liblist.component';
import { LibloginComponent } from './liblogin/liblogin.component';
import { LibrarianheaderComponent } from './librarianheader/librarianheader.component';
import { LibrarianhomeComponent } from './librarianhome/librarianhome.component';
import { LibrarianprofileComponent } from './librarianprofile/librarianprofile.component';
import { LibregisterComponent } from './libregister/libregister.component';
import { LoginComponent } from './login/login.component';
import { LogoutModalComponent } from './logout-modal/logout-modal.component';
import { PaymentComponent } from './payment/payment.component';
import { SelectloginComponent } from './selectlogin/selectlogin.component';
import { UpdateBooksComponent } from './update-books/update-books.component';
import { UploadPicComponent } from './upload-pic/upload-pic.component';
import { UserheaderComponent } from './userheader/userheader.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { UserhomelistComponent } from './userhomelist/userhomelist.component';
import { UserlistComponent } from './userlist/userlist.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { UserregisterComponent } from './userregister/userregister.component';

const routes: Routes = [

  { path: "login",component: LoginComponent },
  { path: "userregister",component: UserregisterComponent },
  { path: "forget",component: ForgetComponent },


  { path: "libregister",component: LibregisterComponent },
  { path: "liblogin",component: LibloginComponent },
  
  
  { path: "adminregister",component: AdminregisterComponent},
  { path: "adminlogin",component: AdminloginComponent },



  { path: "header",component: HeaderComponent },
  { path: "footer",component: FooterComponent },
  { path: "home",component: HomeComponent },
  { path: "aboutus",component: AboutUsComponent},
  { path: "contactus",component: ContactUsComponent},
  { path: "faq",component: FaqComponent},
  { path: "logoutmodal",component: LogoutModalComponent},
  { path: "selectlogin",component: SelectloginComponent },
  { path: "error",component: ErrorComponent },

  
  { path: "upload-pic",component: UploadPicComponent },
  { path: "userprofile",component: UserprofileComponent },


  //librarian
  { path: "addbooks",component: AddBooksComponent},
  { path: "update-books/:id",component: UpdateBooksComponent},
  { path: "booklist",component: BookListComponent},
  { path: "books-details/:id",component: BooksDetailsComponent},
  { path: "emailtext",component: EmailtextComponent },
  { path: "libprofile",component: LibrarianprofileComponent},
  { path: "libforget",component: LibforgetComponent },
  
     
 
//admin
  { path: "adminprofile",component: AdminprofileComponent},
  { path: "liblist",component: LiblistComponent },
  { path: "userlist",component: UserlistComponent },
  { path: "adminforget",component: AdminforgetComponent },



  //user
  { path: "addtocart/:id",component: AddtocartComponent},
  { path: "comment",component: CommentComponent},
  { path: "pgresponse",component: PaymentComponent},



  { path: "emailhome",component: EmailhomeComponent },
  { path: "emailattachment",component: EmailattachmentComponent },
 
 
  
  { path: "userhomelist",component: UserhomelistComponent , 
    children:[
      { path: "userheader",component: UserheaderComponent },
      
     
     
    ]},

    { path: "librarianhome",component: LibrarianhomeComponent , 
    children:[
     
      { path: "librarianheader",component: LibrarianheaderComponent},
     
      
    ]},

    { path: "adminhome",component: AdminhomeComponent , 
    children:[
     
      { path: "adminheader",component: AdminheaderComponent},
      
    ]},
 
  
 
  { path: "", redirectTo:'/home', pathMatch:'full'},
  { path: "**",component: ErrorComponent }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
