package book.store.mapper;

import book.store.config.MapperConfig;
import book.store.dto.request.CreateBookRequestDto;
import book.store.dto.response.BookDto;
import book.store.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto createBookRequestDto);
}
