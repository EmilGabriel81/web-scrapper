package com.scrapper.scrapper.service;


import org.common.dto.BookDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BookService {
    CompletableFuture<List<BookDTO>> getBooks();
}
