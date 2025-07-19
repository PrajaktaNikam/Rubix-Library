package com.rubix.library.Services;

//#########################################

import com.rubix.library.Dto.TeacherIssuedBookDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// Service Interface
public interface TeacherIssuedBookDetailService {
    TeacherIssuedBookDetailDTO create(TeacherIssuedBookDetailDTO dto);
    TeacherIssuedBookDetailDTO update(Integer id, TeacherIssuedBookDetailDTO dto);
    TeacherIssuedBookDetailDTO getById(Integer id);
    void delete(Integer id);
    List<TeacherIssuedBookDetailDTO> filterByBookId(Integer bookId);
    List<TeacherIssuedBookDetailDTO> filterByTeacherId(String teacherId);
    Page<TeacherIssuedBookDetailDTO> getAll(Pageable pageable);
}