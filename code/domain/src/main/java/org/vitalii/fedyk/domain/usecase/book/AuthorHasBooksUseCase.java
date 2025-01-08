package org.vitalii.fedyk.domain.usecase.book;

public interface AuthorHasBooksUseCase {
    boolean execute(long authorId);
}
