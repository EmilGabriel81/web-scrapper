package com.scrapper.scrapper.service;


import com.scrapper.scrapper.entity.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooks();
}
