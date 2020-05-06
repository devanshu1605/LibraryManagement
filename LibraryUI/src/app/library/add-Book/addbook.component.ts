import { Component } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { FormControl } from '@angular/forms';
import { Books } from '../model/Books';
import { Library } from '../model/Library';

@Component({
  templateUrl: "./addbook.component.html"
})
export class AddBookComponent {
  title: string = "Add Book";
  success: boolean = false;
  show: boolean = true;
  showError: boolean = false;
  errorMsg: string;
  bookname = new FormControl('');
  libname = new FormControl('');
  error: string = 'Please fill Book name';

  libraries: Library[];
  constructor(private libraryService: LibraryService) {
    console.log(" Book List Component called");
  }

  ngOnInit() {
    this.libraryService.getLibraries().subscribe(data => this.libraries = data);
  }

  addBook(): void {
    if (this.bookname.value !== null && this.bookname.value.trim() !== "") {
      this.showError = false;
      const book: Books = {
        "bookId": 0,
        "bookName": this.bookname.value,
        "libraryId": +this.libname.value
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
    } else {
      this.showError = true;
    }
  }


}
