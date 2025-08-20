package com.scrapper.scrapper.service;


import com.scrapper.scrapper.entity.BookDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BookService {
    CompletableFuture<List<BookDTO>> getBooks();
}
