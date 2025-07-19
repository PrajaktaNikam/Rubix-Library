package com.rubix.library.Controllers;


import com.rubix.library.Dto.AuthorDTO;
import com.rubix.library.Dto.TeacherIssuedBookDetailDTO;
import com.rubix.library.Services.AuthorService;
import com.rubix.library.Services.TeacherIssuedBookDetailService;
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

//#########################################

// Controller
@RestController
@RequestMapping("/api/issuedBooks/teacher")
@RequiredArgsConstructor
//@Tag(name = "TeacherIssuedBook Controller", description = "Teacher-issued book details")
class TeacherIssuedBookDetailController {

    private final TeacherIssuedBookDetailService service;

    @PostMapping
    //@Operation(summary = "Create new issued-book detail")
    public ResponseEntity<TeacherIssuedBookDetailDTO> create(@RequestBody TeacherIssuedBookDetailDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    //@Operation(summary = "Update issued-book detail by ID")
    public ResponseEntity<TeacherIssuedBookDetailDTO> update(
            @PathVariable Integer id,
            @RequestBody TeacherIssuedBookDetailDTO dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
    //@Operation(summary = "Get issued-book detail by ID")
    public ResponseEntity<TeacherIssuedBookDetailDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    //@Operation(summary = "Delete issued-book detail by ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter/book")
    //@Operation(summary = "Filter by Book ID")
    public ResponseEntity<List<TeacherIssuedBookDetailDTO>> byBook(@RequestParam Integer bookId) {
        return ResponseEntity.ok(service.filterByBookId(bookId));
    }

    @GetMapping("/filter/teacher")
    //@Operation(summary = "Filter by Teacher ID (contains)")
    public ResponseEntity<List<TeacherIssuedBookDetailDTO>> byTeacher(@RequestParam String teacherId) {
        return ResponseEntity.ok(service.filterByTeacherId(teacherId));
    }

    @GetMapping
    //@Operation(summary = "Paged & sorted list of issued-book details")
    public ResponseEntity<Page<TeacherIssuedBookDetailDTO>> list(
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

