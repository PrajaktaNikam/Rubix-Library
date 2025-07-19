package com.rubix.library.Model;

//####################################################


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.context.annotation.*;



//#########################################

// Entity
@Entity
@Table(name = "lib_teacher_issued_book_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherIssuedBookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISSUED_TEACHER_BOOK_DETAIL_ID")
    private Integer issuedTeacherBookDetailId;

    @Column(name = "BOOK_ID")
    private Integer bookId;

    @Column(name = "TEACHER_ID", length = 150)
    private String teacherId;

    @Column(name = "ISSUES_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime issuesDate;

    @Column(name = "RETURN_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime returnDate;

    @Column(name = "RETRUN_STATUS")
    private Integer retrunStatus;

    @Column(name = "FINE")
    private Integer fine;

    @Column(name = "REMARK", columnDefinition = "MEDIUMTEXT")
    private String remark;

    @Column(name = "CREATED_BY", nullable = false)
    private Integer createdBy;

    @Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private Integer updatedBy;

    @Column(name = "UPDATED_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedDate;
}

