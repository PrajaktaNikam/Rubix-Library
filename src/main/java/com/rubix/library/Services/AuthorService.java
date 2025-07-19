package com.rubix.library.Services;

//////////////////////////////////////////////////////////////////
// Author Service Interface

import com.rubix.library.Dto.AuthorDTO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//////////////////////////////////////////////////////////////////

public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO dto);
    AuthorDTO updateAuthor(Integer id, AuthorDTO dto);
    AuthorDTO getAuthorById(Integer id);
    void deleteAuthor(Integer id);
    List<AuthorDTO> filterAuthorsByName(String name);
    Page<AuthorDTO> getAllAuthors(Pageable pageable);
}


