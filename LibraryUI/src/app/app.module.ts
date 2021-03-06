import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './library/book-list/book-list.component';
import { LibraryComponent } from './library/library.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { UpdateBookComponent } from './library/update-book/update.component';
import { AddBookComponent } from './library/add-book/addbook.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    LibraryComponent,
    UpdateBookComponent,
    AddBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    HttpClient,
    RouterModule.forRoot([
      { path: 'home', component: LibraryComponent },
      { path: 'library', component: LibraryComponent },
      { path: 'booklist/:id', component: BookListComponent },
      { path: 'update/:bookid', component: UpdateBookComponent },
      { path: 'addBook', component: AddBookComponent },
      { path: '**', component: LibraryComponent },
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
