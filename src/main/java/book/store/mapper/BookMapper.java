package book.store.mapper;

import book.store.config.MapperConfig;
import book.store.dto.request.CreateBookRequestDto;
import book.store.dto.response.BookDto;
import book.store.dto.response.BookDtoWithoutCategoryIds;
import book.store.model.Book;
import book.store.model.Category;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    @Mapping(target = "categoriesIds", ignore = true)
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto createBookRequestDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        bookDto.setCategoriesIds(book.getCategories().stream()
                .map(Category::getId)
                .collect(Collectors.toSet()));
    }
}
