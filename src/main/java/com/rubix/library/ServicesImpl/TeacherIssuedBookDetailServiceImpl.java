package com.rubix.library.ServicesImpl;


//#########################################

import com.rubix.library.Dto.TeacherIssuedBookDetailDTO;
import com.rubix.library.Model.TeacherIssuedBookDetail;
import com.rubix.library.Repositories.TeacherIssuedBookDetailRepository;
import com.rubix.library.Services.TeacherIssuedBookDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
// Service Implementation
@Service
@RequiredArgsConstructor
class TeacherIssuedBookDetailServiceImpl implements TeacherIssuedBookDetailService {

    private final TeacherIssuedBookDetailRepository repo;

    @Override
    public TeacherIssuedBookDetailDTO create(TeacherIssuedBookDetailDTO dto) {
        TeacherIssuedBookDetail ent = TeacherIssuedBookDetail.builder()
                .bookId(dto.getBookId())
                .teacherId(dto.getTeacherId())
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
        TeacherIssuedBookDetail saved = repo.save(ent);
        dto.setIssuedTeacherBookDetailId(saved.getIssuedTeacherBookDetailId());
        return dto;
    }

    @Override
    public TeacherIssuedBookDetailDTO update(Integer id, TeacherIssuedBookDetailDTO dto) {
        TeacherIssuedBookDetail ent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        //BeanUtils.copyProperties(dto, ent, "issuedTeacherBookDetailId", "createdBy", "createdDate");
        TeacherIssuedBookDetail updated = repo.save(ent);
        return toDTO(updated);
    }

    @Override
    public TeacherIssuedBookDetailDTO getById(Integer id) {
        return repo.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<TeacherIssuedBookDetailDTO> filterByBookId(Integer bookId) {
        return repo.findByBookId(bookId).stream().map(this::toDTO).toList();
    }

    @Override
    public List<TeacherIssuedBookDetailDTO> filterByTeacherId(String teacherId) {
        return repo.findByTeacherIdContainingIgnoreCase(teacherId).stream().map(this::toDTO).toList();
    }

    @Override
    public Page<TeacherIssuedBookDetailDTO> getAll(Pageable pageable) {
        return repo.findAll(pageable).map(this::toDTO);
    }

    private TeacherIssuedBookDetailDTO toDTO(TeacherIssuedBookDetail ent) {
        return TeacherIssuedBookDetailDTO.builder()
                .issuedTeacherBookDetailId(ent.getIssuedTeacherBookDetailId())
                .bookId(ent.getBookId())
                .teacherId(ent.getTeacherId())
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
