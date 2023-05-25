package com.book.controller;

import java.util.List;

import com.book.dto.BookDto;
import com.book.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {
	
	private final BookServiceImpl bookService;
	
	@PostMapping()
	public ResponseEntity<BookDto> addBook(@RequestBody(required = false) BookDto bookDto){
		log.info("Start of addBook");
		BookDto addedBook = bookService.addBook(bookDto);
		log.info("End of addBook");
		return ResponseEntity.ok().body(addedBook);
	}
	
	//retrieve a book with specific id
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> getBookById(
			@PathVariable
					long id) {
		log.info("Start of getBookById");
		BookDto bookById = bookService.getBookById(id);
		log.info("End of getBookById");
		return ResponseEntity.ok().body(bookById);
	}
	
	
	//update a book with specific id
	@PutMapping("/{id}")
	public ResponseEntity<BookDto> updateBook(
			@PathVariable("id")
					long id,
			@RequestBody
					BookDto bookDto) {
		log.info("Start of updateBook");
		BookDto updatedBook = bookService.updateBook(id, bookDto);
		log.info("End of updateBook");
		return ResponseEntity.ok().body(updatedBook);
	}
	
	
	//return all the books
	@GetMapping()
	public ResponseEntity<List<BookDto>> getBooks() {
		log.info("Start of getBooks");
		List<BookDto> allbooks = bookService.getAllBooks();
		log.info("End of getBooks");
		return ResponseEntity.ok().body(allbooks);
	}
	
	
	//delete a book of specific id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(
			@PathVariable
					Long id) {
		log.info("Start of deleteBook");
		bookService.deleteById(id);
		log.info("End of deleteBook");
		return ResponseEntity.noContent().build();
	}
	
}
