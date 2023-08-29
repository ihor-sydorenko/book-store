package book.store.service;

import book.store.dto.request.CreateBookRequestDto;
import book.store.dto.response.BookDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto update(Long id, CreateBookRequestDto createBookRequestDto);

    void deleteById(Long id);

    List<BookDto> findByTitle(String title);
}
