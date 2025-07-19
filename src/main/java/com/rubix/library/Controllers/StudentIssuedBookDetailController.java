package com.rubix.library.Controllers;
import com.rubix.library.Dto.AuthorDTO;
import com.rubix.library.Dto.StudentIssuedBookDetailDTO;
import com.rubix.library.Services.AuthorService;
import com.rubix.library.Services.StudentIssuedBookDetailService;
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


//#########################################

// Controller
@RestController
@RequestMapping("/api/issuedBooks/student")
@RequiredArgsConstructor
//@Tag(name = "StudentIssuedBook Controller", description = "Student-issued book details")
class StudentIssuedBookDetailController {

    private final StudentIssuedBookDetailService service;

    @PostMapping
   // @Operation(summary = "Create new issued-book detail")
    public ResponseEntity<StudentIssuedBookDetailDTO> create(@RequestBody StudentIssuedBookDetailDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
   // @Operation(summary = "Update issued-book detail by ID")
    public ResponseEntity<StudentIssuedBookDetailDTO> update(
            @PathVariable Integer id,
            @RequestBody StudentIssuedBookDetailDTO dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
   // @Operation(summary = "Get issued-book detail by ID")
    public ResponseEntity<StudentIssuedBookDetailDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
   // @Operation(summary = "Delete issued-book detail by ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/book")
   // @Operation(summary = "Filter by Book ID")
    public ResponseEntity<List<StudentIssuedBookDetailDTO>> byBook(@RequestParam Integer bookId) {
        return ResponseEntity.ok(service.filterByBookId(bookId));
    }

    @GetMapping("/filter/student")
    //@Operation(summary = "Filter by Student ID (contains)")
    public ResponseEntity<List<StudentIssuedBookDetailDTO>> byStudent(@RequestParam String studentId) {
        return ResponseEntity.ok(service.filterByStudentId(studentId));
    }

    @GetMapping
    //@Operation(summary = "Paged & sorted list of issued-book details")
    public ResponseEntity<Page<StudentIssuedBookDetailDTO>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "issuesDate") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(service.getAll(pageable));
    }
}

