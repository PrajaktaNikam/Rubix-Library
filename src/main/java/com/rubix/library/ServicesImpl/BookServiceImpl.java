package com.rubix.library.ServicesImpl;


//////////////////////////////////////////////////////////////////
// Book Service Implementation

import com.rubix.library.Dto.BookDTO;
import com.rubix.library.Repositories.BookRepository;
import com.rubix.library.Services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rubix.library.Model.Book;
import java.util.List;
import java.util.stream.Collectors;

//////////////////////////////////////////////////////////////////

@Service
@RequiredArgsConstructor
class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDTO createBook(BookDTO dto) {
        Book book = Book.builder()
                .bookName(dto.getBookName())
                .bookCategoryId(dto.getBookCategoryId())
                .authorId(dto.getAuthorId())
                .isBnnumber(dto.getIsBnnumber())
                .bookPrice(dto.getBookPrice())
                .bookImage(dto.getBookImage())
                .isIssued(dto.getIsIssued())
                .regDate(dto.getRegDate())
                .bookQty(dto.getBookQty())
                .createdBy(dto.getCreatedBy())
                .createdDate(dto.getCreatedDate())
                .updatedBy(dto.getUpdatedBy())
                .updatedDate(dto.getUpdatedDate())
                .build();
        Book saved = bookRepository.save(book);
        dto.setBookId(saved.getBookId());
        return dto;
    }

    @Override
    public BookDTO updateBook(Integer id, BookDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        //BeanUtils.copyProperties(dto, book, "bookId", "createdBy", "createdDate");
        Book updated = bookRepository.save(book);
        return toDTO(updated);
    }

    @Override
    public BookDTO getBookById(Integer id) {
        return bookRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> filterByName(String name) {
        return bookRepository.findByBookNameContainingIgnoreCase(name)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> filterByAuthorId(Integer authorId) {
        return bookRepository.findByAuthorId(authorId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<BookDTO> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(this::toDTO);
    }

    private BookDTO toDTO(Book book) {

        return BookDTO.builder()
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .bookCategoryId(book.getBookCategoryId())
                .authorId(book.getAuthorId())
                .isBnnumber(book.getIsBnnumber())
                .bookPrice(book.getBookPrice())
                .bookImage(book.getBookImage())
                .isIssued(book.getIsIssued())
                .regDate(book.getRegDate())
                .bookQty(book.getBookQty())
                .createdBy(book.getCreatedBy())
                .createdDate(book.getCreatedDate())
                .updatedBy(book.getUpdatedBy())
                .updatedDate(book.getUpdatedDate())
                .build();
    }
}
