package com.rubix.library.Repositories;
import com.rubix.library.Model.Author;
import com.rubix.library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
//////////////////////////////////////////////////////////////////
// Book Repository
//////////////////////////////////////////////////////////////////

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByBookNameContainingIgnoreCase(String name);
    List<Book> findByAuthorId(Integer authorId);
}
