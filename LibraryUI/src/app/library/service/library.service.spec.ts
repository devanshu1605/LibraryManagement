
import { TestBed, async, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { LibraryService } from './library.service';
import { HttpClient, HttpErrorResponse, HttpHandler, HttpResponse, HttpEvent } from '@angular/common/http';
import { Books } from '../model/Books';

describe('PostService', () => {
  let libraryService: LibraryService;
  let httpMock: HttpTestingController;
  let httpClient: HttpClient;
  let book: Books;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule,
      ],
      providers: [
        LibraryService
      ],
    });

    libraryService = TestBed.get(LibraryService);
    httpMock = TestBed.get(HttpTestingController);
    httpClient = TestBed.get(HttpClient);
  });

  it(`should fetch libraries as an Observable`, async(inject([HttpTestingController, LibraryService],
    (httpClient: HttpTestingController, libraryService: LibraryService) => {

      libraryService.getLibraries()
        .subscribe((data: any) => {
          expect(data.length).toBe(1);
        });

    })));

  it(`should fetch books as an Observable`, async(inject([HttpTestingController, LibraryService],
    (httpClient: HttpTestingController, libraryService: LibraryService) => {

      libraryService.getBooks(123)
        .subscribe(response => {
          expect(response.values).toBeGreaterThanOrEqual(0);
        });

    })));

  it(`should add books`, async(inject([HttpTestingController, LibraryService],
    (httpClient: HttpTestingController, libraryService: LibraryService) => {
      this.book = [{
        "bookId": 123,
        "bookName": "Book1",
        "libraryId": 1
      }];
      libraryService.addorUpdateBooks(book)
        .subscribe(response => {
          expect(response.message).toContain("success");
        });

    })));
});
