package com.scrapper.scrapper.service.impl;

import com.scrapper.scrapper.entity.BookDTO;
import com.scrapper.scrapper.repository.BookRepository;
import com.scrapper.scrapper.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDTO> getBooks() {
        return bookRepository.findAll();
    }
}
