package org.levi.demomybatispvh.service;

import org.levi.demomybatispvh.model.Book;
import org.levi.demomybatispvh.model.dto.request.BookRequest;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();

    Book createBook(BookRequest bookRequest);
}
