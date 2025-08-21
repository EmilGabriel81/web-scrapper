package com.scrapper.scrapper.controller;

import com.scrapper.scrapper.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.common.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("scrapper")
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get list of books")
    public CompletableFuture<List<BookDTO>> getBooks() {
        return bookService.getBooks();
    }
}
