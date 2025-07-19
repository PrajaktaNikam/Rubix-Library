package com.rubix.library.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;


//#########################################

// Entity
@Entity
@Table(name = "lib_stud_issued_book_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentIssuedBookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISSUED_STUD_BOOK_DETAIL_ID")
    private Integer issuedStudBookDetailId;

    @Column(name = "BOOK_ID")
    private Integer bookId;

    @Column(name = "STUDENT_ID", length = 150)
    private String studentId;

    @Column(name = "ISSUES_DATE")
    private LocalDateTime issuesDate;

    @Column(name = "RETURN_DATE")
    private LocalDateTime returnDate;

    @Column(name = "RETRUN_STATUS")
    private Integer retrunStatus;

    @Column(name = "FINE")
    private Integer fine;

    @Column(name = "REMARK", columnDefinition = "MEDIUMTEXT")
    private String remark;

    @Column(name = "CREATED_BY", nullable = false)
    private Integer createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private Integer updatedBy;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}


