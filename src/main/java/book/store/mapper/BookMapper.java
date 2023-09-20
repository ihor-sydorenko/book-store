package book.store.mapper;

import book.store.config.MapperConfig;
import book.store.dto.request.CreateBookRequestDto;
import book.store.dto.response.BookDto;
import book.store.dto.response.BookDtoWithoutCategoryIds;
import book.store.model.Book;
import book.store.model.Category;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    @Mapping(target = "categoryIds", ignore = true)
    BookDto toDto(Book book);

    @Mapping(target = "categories", ignore = true)
    Book toModel(CreateBookRequestDto createBookRequestDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        bookDto.setCategoryIds(book.getCategories().stream()
                .map(Category::getId)
                .collect(Collectors.toSet()));
    }

    @AfterMapping
    default void setCategoriesIntoBook(@MappingTarget Book book,
                                       CreateBookRequestDto createBookRequestDto) {
        Set<Category> categories = new HashSet<>();
        for (Long categoryId : createBookRequestDto.getCategoryIds()) {
            Category category = new Category();
            category.setId(categoryId);
            categories.add(category);
        }
        book.setCategories(categories);
    }
}
