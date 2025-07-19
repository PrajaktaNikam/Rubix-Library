package com.rubix.library.Dto;


//#########################################
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
// DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherIssuedBookDetailDTO {
    private Integer issuedTeacherBookDetailId;
    private Integer bookId;
    private String teacherId;
    private LocalDateTime issuesDate;
    private LocalDateTime returnDate;
    private Integer retrunStatus;
    private Integer fine;
    private String remark;
    private Integer createdBy;
    private LocalDateTime createdDate;
    private Integer updatedBy;
    private LocalDateTime updatedDate;
}
