package com.rubix.library.ServicesImpl;

//////////////////////////////////////////////////////////////////
// Author Service Implementation

import com.rubix.library.Dto.AuthorDTO;
import com.rubix.library.Model.Author;
import com.rubix.library.Repositories.AuthorRepository;
import com.rubix.library.Services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//////////////////////////////////////////////////////////////////

@Service
@RequiredArgsConstructor
class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDTO createAuthor(AuthorDTO dto) {
        Author author = Author.builder()
                .authorName(dto.getAuthorName())
                .createdBy(dto.getCreatedBy())
                .createdDate(dto.getCreatedDate())
                .updatedBy(dto.getUpdatedBy())
                .updatedDate(dto.getUpdatedDate())
                .build();
        Author saved = authorRepository.save(author);
        dto.setAuthorId(saved.getAuthorId());
        return dto;
    }

    @Override
    public AuthorDTO updateAuthor(Integer id, AuthorDTO dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
       /* BeanUtils.copyProperties(dto, author, "authorId", "createdDate", "createdBy");*/
        Author updated = authorRepository.save(author);
        return convertToDTO(updated);
    }

    @Override
    public AuthorDTO getAuthorById(Integer id) {
        return authorRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDTO> filterAuthorsByName(String name) {
        return authorRepository.findByAuthorNameContainingIgnoreCase(name)
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Page<AuthorDTO> getAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    private AuthorDTO convertToDTO(Author author) {
        return AuthorDTO.builder()
                .authorId(author.getAuthorId())
                .authorName(author.getAuthorName())
                .createdBy(author.getCreatedBy())
                .createdDate(author.getCreatedDate())
                .updatedBy(author.getUpdatedBy())
                .updatedDate(author.getUpdatedDate())
                .build();
    }
}

