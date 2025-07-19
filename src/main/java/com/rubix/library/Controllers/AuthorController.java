package com.rubix.library.Controllers;

//////////////////////////////////////////////////////////////////
// Author Controller
import com.rubix.library.Dto.AuthorDTO;
import com.rubix.library.Services.AuthorService;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;



@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
//@Tag(name = "Author Controller", description = "Author CRUD and filtering APIs")
class AuthorController {

    private final AuthorService authorService;

    @PostMapping
   // @Operation(summary = "Create new author")
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO dto) {
        return ResponseEntity.ok(authorService.createAuthor(dto));
    }

    @PutMapping("/{id}")
    //@Operation(summary = "Update author by ID")
    public ResponseEntity<AuthorDTO> update(@PathVariable Integer id, @RequestBody AuthorDTO dto) {
        return ResponseEntity.ok(authorService.updateAuthor(id, dto));
    }

    @GetMapping("/{id}")
    //@Operation(summary = "Get author by ID")
    public ResponseEntity<AuthorDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @DeleteMapping("/{id}")
    //@Operation(summary = "Delete author by ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    //@Operation(summary = "Filter authors by name (case-insensitive)")
    public ResponseEntity<List<AuthorDTO>> filterByName(@RequestParam String name) {
        return ResponseEntity.ok(authorService.filterAuthorsByName(name));
    }

    @GetMapping
    //@Operation(summary = "Get paginated and sorted list of authors")
    public ResponseEntity<Page<AuthorDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "authorName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(authorService.getAllAuthors(pageable));
    }

    @GetMapping("/getMsg")
    String getMsg(){
        return "Running Rubix Lib";
    }
}
