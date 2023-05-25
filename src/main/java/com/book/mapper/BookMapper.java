package com.book.mapper;

import com.book.dto.BookDto;
import com.book.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
	
	BookDto mapEntityToDto(BookEntity book);
	
	BookEntity mapDtoToEntity(BookDto bookDto);
}
