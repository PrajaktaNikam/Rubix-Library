package com.rubix.library.Services;


//#########################################

import com.rubix.library.Dto.StudentIssuedBookDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// Service Interface
public interface StudentIssuedBookDetailService {
    StudentIssuedBookDetailDTO create(StudentIssuedBookDetailDTO dto);
    StudentIssuedBookDetailDTO update(Integer id, StudentIssuedBookDetailDTO dto);
    StudentIssuedBookDetailDTO getById(Integer id);
    void delete(Integer id);
    List<StudentIssuedBookDetailDTO> filterByBookId(Integer bookId);
    List<StudentIssuedBookDetailDTO> filterByStudentId(String studentId);
    Page<StudentIssuedBookDetailDTO> getAll(Pageable pageable);
}