package com.book.service;

import java.util.List;

import com.book.dto.BookDto;

public interface BookService {
	
	BookDto addBook(BookDto bookDto);
	
	BookDto getBookById(long id);
	
	List<BookDto> getAllBooks();
	
	void deleteById(long id);
	
	BookDto updateBook(long id, BookDto bookDto);
	
}
