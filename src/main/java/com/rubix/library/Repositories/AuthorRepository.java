package com.rubix.library.Repositories;

//////////////////////////////////////////////////////////////////
// Author Repository

import com.rubix.library.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//////////////////////////////////////////////////////////////////

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByAuthorNameContainingIgnoreCase(String name);
}
