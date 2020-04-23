import { Component } from '@angular/core';
import { LibraryService } from './library.service';
import { FormControl } from '@angular/forms';
import { Books } from './Books';
import { Library } from './Library';

@Component({
  templateUrl: "./addbook.component.html"
})
export class AddBookComponent {
  title: string = "Add Book";
  success: boolean = false;
  show: boolean = true;
  errorMsg: string;
  bookname = new FormControl('');
  _libname: string = '';

  get libname(): string {
    return this._libname;
  }

  set libname(value: string) {
    this._libname = value;
  }

  libraries: Library[];
  constructor(private libraryService: LibraryService) {
    console.log(" Book List Component called");
  }

  ngOnInit() {
    this.libraryService.getLibraries().subscribe(data => this.libraries = data);
  }


  addBook(): void {
    const book: Books = {
      "bookId": 0,
      "bookName": this.bookname.value,
      "libraryId": +this._libname
    };

    this.libraryService.addorUpdateBooks(book).subscribe({
      next: response => {
        console.log("this.response body " + response.message);
        if (response.message == 'success') {
          this.success = true;
          this.show = false;
        }

      },
      error: err => this.errorMsg = err
    });
  }


}
