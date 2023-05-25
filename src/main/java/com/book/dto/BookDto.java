package com.book.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class BookDto {
	
	private Long id;
	private String title;
	private String author;
}
