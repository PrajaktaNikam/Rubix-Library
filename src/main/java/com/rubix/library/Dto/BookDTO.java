package com.rubix.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// Book DTO
//////////////////////////////////////////////////////////////////

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Integer bookId;
    private String bookName;
    private Integer bookCategoryId;
    private Integer authorId;
    private String isBnnumber;
    private BigDecimal bookPrice;
    private String bookImage;
    private Integer isIssued;
    private LocalDateTime regDate;
    private Integer bookQty;
    private Integer createdBy;
    private LocalDateTime createdDate;
    private Integer updatedBy;
    private LocalDateTime updatedDate;
}
