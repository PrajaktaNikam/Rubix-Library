package com.rubix.library.Repositories;
import com.rubix.library.Model.TeacherIssuedBookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
//#########################################

// Repository
@Repository
public interface TeacherIssuedBookDetailRepository extends JpaRepository<TeacherIssuedBookDetail, Integer> {
    List<TeacherIssuedBookDetail> findByBookId(Integer bookId);
    List<TeacherIssuedBookDetail> findByTeacherIdContainingIgnoreCase(String teacherId);
}