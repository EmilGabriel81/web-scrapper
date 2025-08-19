package com.scrapper.scrapper.service;


import com.scrapper.scrapper.entity.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> getBooks();
}
