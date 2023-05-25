package com.book.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.book.dto.BookDto;
import com.book.mapper.BookMapper;
import com.book.entity.BookEntity;
import com.book.exception.BookException;
import com.book.repository.BookRepository;
import com.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl {
	
	private final BookRepository bookRepository;
	
	private final BookMapper mapper;
	
	//add book
//	public BookDto addBook(BookDto bookDto) {
//	}
	
	//get book by id
//	public BookDto getBookById(long id) {
//	}
	
	//update book
//	public BookDto updateBook(long id, BookDto bookDto) {
//	}
//
	//get all books
//	public List<BookDto> getAllBooks() {
//	}
	
	//delete book
//	public void deleteById(long id) {
//
//	}

}
