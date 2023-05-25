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
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	
	private final BookMapper mapper;
	
	
	public BookDto addBook(BookDto bookDto) {
		if (ObjectUtils.isEmpty(bookDto)) {
			throw new BookException("the book resource cannot be null or empty");
		}
		BookEntity bookEntity = mapper.mapDtoToEntity(bookDto);
		log.info("Saving new book");
		BookEntity savedBook = bookRepository.save(bookEntity);
		return mapper.mapEntityToDto(savedBook);
	}
	
	
	public BookDto getBookById(long id) {
		BookEntity fetchedBook = getBookEntityById(id);
		return mapper.mapEntityToDto(fetchedBook);
	}
	
	
	public BookDto updateBook(long id, BookDto bookDto) {
		if (ObjectUtils.isEmpty(bookDto)) {
			throw new BookException("book cannot be null or empty");
		}
		BookEntity bookEntity = getBookEntityById(id);
		Optional.ofNullable(bookDto.getAuthor())
				.ifPresent(author -> bookEntity.setAuthor(author));
		Optional.ofNullable(bookDto.getTitle()).ifPresent(title -> bookEntity.setTitle(title));
		log.info("Updating book");
		return mapper.mapEntityToDto(bookRepository.save(bookEntity));
	}
	
	
	public List<BookDto> getAllBooks() {
		
		List<BookDto> books = bookRepository.findAll().stream()
				.map(mapper::mapEntityToDto)
				.collect(Collectors.toList());
		return books;
		
	}
	
	
	public void deleteById(long id) {
		log.info("Deleting book with id {}", id);
		try {
			bookRepository.deleteById(id);
		} catch (EmptyResultDataAccessException exception) {
			throw new BookException("Book with id " + id + " does not exists");
		}
	}
	
	
	private BookEntity getBookEntityById(long id) {
		log.info("Retrieving book with id {}", id);
		return bookRepository.findById(id)
				.orElseThrow(() -> new BookException("The book with id " + id + " cannot be found"));
	}
}
