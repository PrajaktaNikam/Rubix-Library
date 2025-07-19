package com.rubix.library.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "lib_authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Integer authorId;

    @Column(name = "AUTHOR_NAME", length = 159)
    private String authorName;

    @Column(name = "CREATED_BY", nullable = false)
    private Integer createdBy;

    @Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private Integer updatedBy;

    @Column(name = "UPDATED_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedDate;
}
