package com.rubix.library.Repositories;
import com.rubix.library.Model.StudentIssuedBookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

//###################################################################################
// Repository
@Repository
public interface StudentIssuedBookDetailRepository extends JpaRepository<StudentIssuedBookDetail, Integer> {
    List<StudentIssuedBookDetail> findByBookId(Integer bookId);
    List<StudentIssuedBookDetail> findByStudentIdContainingIgnoreCase(String studentId);
}
