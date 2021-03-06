import { Component, OnInit, Input} from '@angular/core';
import { Books } from '../model/Books';
import { Library } from '../model/Library';
import { LibraryService } from '../service/library.service';


@Component({
  selector: 'book-list',
  templateUrl: './book-list.component.html',
})

export class BookListComponent implements OnInit {
  errorMsg: string;
  @Input() libraries: Library[];
  @Input() libraryId: number;

  constructor(private libraryService: LibraryService) {
    console.log(" Book List Component called");
  }

  ngOnInit(): void {

    console.log("nginit  BookListComponent called" + this.libraryId);
    this.libraryService.getBooks(this.libraryId).subscribe({
      next: books => {
        this.books = books;
      },
      error: err => this.errorMsg = err
    });
  }

  books: Books[];
}
