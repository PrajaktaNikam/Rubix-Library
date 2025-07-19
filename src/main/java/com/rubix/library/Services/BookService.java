package com.rubix.library.Services;



//////////////////////////////////////////////////////////////////
// Book Service Interface

import com.rubix.library.Dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//////////////////////////////////////////////////////////////////

public interface BookService {
    BookDTO createBook(BookDTO dto);
    BookDTO updateBook(Integer id, BookDTO dto);
    BookDTO getBookById(Integer id);
    void deleteBook(Integer id);
    List<BookDTO> filterByName(String name);
    List<BookDTO> filterByAuthorId(Integer authorId);
    Page<BookDTO> getAllBooks(Pageable pageable);
}