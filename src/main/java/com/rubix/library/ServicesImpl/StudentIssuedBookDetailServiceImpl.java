package com.rubix.library.ServicesImpl;

//#########################################

import com.rubix.library.Dto.StudentIssuedBookDetailDTO;
import com.rubix.library.Model.StudentIssuedBookDetail;
import com.rubix.library.Repositories.StudentIssuedBookDetailRepository;
import com.rubix.library.Services.StudentIssuedBookDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

// Service Implementation
@Service
@RequiredArgsConstructor
class StudentIssuedBookDetailServiceImpl implements StudentIssuedBookDetailService {

    private final StudentIssuedBookDetailRepository repo;

    @Override
    public StudentIssuedBookDetailDTO create(StudentIssuedBookDetailDTO dto) {
        StudentIssuedBookDetail ent = StudentIssuedBookDetail.builder()
                .bookId(dto.getBookId())
                .studentId(dto.getStudentId())
                .issuesDate(dto.getIssuesDate())
                .returnDate(dto.getReturnDate())
                .retrunStatus(dto.getRetrunStatus())
                .fine(dto.getFine())
                .remark(dto.getRemark())
                .createdBy(dto.getCreatedBy())
                .createdDate(dto.getCreatedDate())
                .updatedBy(dto.getUpdatedBy())
                .updatedDate(dto.getUpdatedDate())
                .build();
        StudentIssuedBookDetail saved = repo.save(ent);
        dto.setIssuedStudBookDetailId(saved.getIssuedStudBookDetailId());
        return dto;
    }

    @Override
    public StudentIssuedBookDetailDTO update(Integer id, StudentIssuedBookDetailDTO dto) {
        StudentIssuedBookDetail ent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        //BeanUtils.copyProperties(dto, ent, "issuedStudBookDetailId", "createdBy", "createdDate");
        StudentIssuedBookDetail updated = repo.save(ent);
        return toDTO(updated);
    }

    @Override
    public StudentIssuedBookDetailDTO getById(Integer id) {
        return repo.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<StudentIssuedBookDetailDTO> filterByBookId(Integer bookId) {
        return repo.findByBookId(bookId).stream().map(this::toDTO).toList();
    }

    @Override
    public List<StudentIssuedBookDetailDTO> filterByStudentId(String studentId) {
        return repo.findByStudentIdContainingIgnoreCase(studentId).stream().map(this::toDTO).toList();
    }

    @Override
    public Page<StudentIssuedBookDetailDTO> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(this::toDTO);
    }

    private StudentIssuedBookDetailDTO toDTO(StudentIssuedBookDetail ent) {
        return StudentIssuedBookDetailDTO.builder()
                .issuedStudBookDetailId(ent.getIssuedStudBookDetailId())
                .bookId(ent.getBookId())
                .studentId(ent.getStudentId())
                .issuesDate(ent.getIssuesDate())
                .returnDate(ent.getReturnDate())
                .retrunStatus(ent.getRetrunStatus())
                .fine(ent.getFine())
                .remark(ent.getRemark())
                .createdBy(ent.getCreatedBy())
                .createdDate(ent.getCreatedDate())
                .updatedBy(ent.getUpdatedBy())
                .updatedDate(ent.getUpdatedDate())
                .build();
    }
}

