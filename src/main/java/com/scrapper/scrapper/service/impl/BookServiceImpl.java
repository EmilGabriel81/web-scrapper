package com.scrapper.scrapper.service.impl;

import com.scrapper.scrapper.repository.BookRepository;
import com.scrapper.scrapper.service.BookService;
import lombok.AllArgsConstructor;
import org.common.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public CompletableFuture<List<BookDTO>> getBooks() {
        return bookRepository.findAll();
    }
}
