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
@RequestMapping("")
public class BookController {
	
	private final BookServiceImpl bookService;
	
	//add a book resource
//	public ResponseEntity<BookDto> addBook(){
//	}
	
	//retrieve a book with specific id
//	public ResponseEntity<BookDto> getBookById() {
//	}
	
	
//	//update a book with specific id
//	public ResponseEntity<BookDto> updateBook() {
//
//	}
	
	
	//return all the books
//	public ResponseEntity<List<BookDto>> getBooks() {
//	}
//
	
	//delete a book of specific id
//	public ResponseEntity<Void> deleteBook() {
//	}
	
}
