package com.rubix.library.Controllers;

//////////////////////////////////////////////////////////////////
// Book Controller

import com.rubix.library.Dto.BookDTO;
import com.rubix.library.Services.BookService;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//////////////////////////////////////////////////////////////////

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
//@Tag(name = "Book Controller", description = "Book CRUD, filtering and sorting APIs")
class BookController {

    private final BookService bookService;

    @PostMapping
    ////@Operation(summary = "Create new book")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO dto) {
        return ResponseEntity.ok(bookService.createBook(dto));
    }

    @PutMapping("/{id}")
    //@Operation(summary = "Update book by ID")
    public ResponseEntity<BookDTO> update(@PathVariable Integer id, @RequestBody BookDTO dto) {
        return ResponseEntity.ok(bookService.updateBook(id, dto));
    }

    @GetMapping("/{id}")
    //@Operation(summary = "Get book by ID")
    public ResponseEntity<BookDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping("/{id}")
    //@Operation(summary = "Delete book by ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/name")
    //@Operation(summary = "Filter books by name")
    public ResponseEntity<List<BookDTO>> filterByName(@RequestParam String name) {
        return ResponseEntity.ok(bookService.filterByName(name));
    }

    @GetMapping("/filter/author")
    //@Operation(summary = "Filter books by author ID")
    public ResponseEntity<List<BookDTO>> filterByAuthor(@RequestParam Integer authorId) {
        return ResponseEntity.ok(bookService.filterByAuthorId(authorId));
    }

    @GetMapping
    //@Operation(summary = "Get paginated and sorted list of books")
    public ResponseEntity<Page<BookDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "bookName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(bookService.getAllBooks(pageable));
    }
}

