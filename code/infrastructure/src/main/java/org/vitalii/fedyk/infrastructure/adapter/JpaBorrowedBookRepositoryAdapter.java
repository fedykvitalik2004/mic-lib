package org.vitalii.fedyk.infrastructure.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.vitalii.fedyk.domain.model.BorrowedBook;
import org.vitalii.fedyk.domain.repository.BorrowedBookRepository;
import org.vitalii.fedyk.domain.vo.BorrowedBookId;
import org.vitalii.fedyk.infrastructure.entity.BorrowedBookEntityId;
import org.vitalii.fedyk.infrastructure.mapper.BorrowedBookEntityMapper;
import org.vitalii.fedyk.infrastructure.repository.BorrowedBookEntityRepository;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaBorrowedBookRepositoryAdapter implements BorrowedBookRepository {
    private BorrowedBookEntityRepository borrowedBookEntityRepository;
    private BorrowedBookEntityMapper borrowedBookEntityMapper;

    @Override
    public boolean existsByBorrowedBookIdUserId(long userId) {
        return borrowedBookEntityRepository.existsByBorrowedBookIdUserId(userId);
    }

    @Override
    public boolean existsByBorrowedBookIdBookId(long bookId) {
        return borrowedBookEntityRepository.existsByBorrowedBookIdBookId(bookId);
    }

    @Override
    public List<BorrowedBook> findByUserId(long userId) {
        return borrowedBookEntityRepository.findByUserId(userId)
                .stream().map(o -> borrowedBookEntityMapper.toBorrowedBook(o))
                .toList();
    }

    @Override
    public BorrowedBook save(BorrowedBook borrowedBook) {
        return borrowedBookEntityMapper.toBorrowedBook(
                borrowedBookEntityRepository.save(
                        borrowedBookEntityMapper.toBorrowedBookEntity(borrowedBook)));
    }

    @Override
    public Optional<BorrowedBook> findById(BorrowedBookId borrowedBookId) {
        return borrowedBookEntityRepository.findById(
                        new BorrowedBookEntityId(borrowedBookId.getBookId(), borrowedBookId.getUserId()))
                .map(o -> borrowedBookEntityMapper.toBorrowedBook(o));
    }

    @Override
    public void delete(BorrowedBookId borrowedBookId) {
        borrowedBookEntityRepository.deleteById(
                new BorrowedBookEntityId(borrowedBookId.getBookId(), borrowedBookId.getUserId()));
    }
}