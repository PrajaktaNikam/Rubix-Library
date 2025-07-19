package com.rubix.library.Model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;



//////////////////////////////////////////////////////////////////
// Book Entity
//////////////////////////////////////////////////////////////////

@Entity
@Table(name = "lib_books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Integer bookId;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "BOOK_CATEGORY_ID")
    private Integer bookCategoryId;

    @Column(name = "AUTHOR_ID")
    private Integer authorId;

    @Column(name = "IS_BNNUMBER", length = 25)
    private String isBnnumber;

    @Column(name = "BOOK_PRICE", precision = 10, scale = 2)
    private BigDecimal bookPrice;

    @Column(name = "BOOK_IMAGE", length = 250, nullable = false)
    private String bookImage;

    @Column(name = "IS_ISSUED")
    private Integer isIssued;

    @Column(name = "REG_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime regDate;

    @Column(name = "BOOK_QTY")
    private Integer bookQty;

    @Column(name = "CREATED_BY", nullable = false)
    private Integer createdBy;

    @Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private Integer updatedBy;

    @Column(name = "UPDATED_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedDate;
}
