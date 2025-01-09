package org.vitalii.fedyk.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.vitalii.fedyk.domain.vo.BorrowedBookId;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BorrowedBook extends BaseEntity<BorrowedBookId>{
    private Book book;
    private ZonedDateTime borrowDate;
    private ZonedDateTime returnDate;
}
