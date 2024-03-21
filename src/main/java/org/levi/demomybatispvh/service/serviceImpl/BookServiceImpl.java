package org.levi.demomybatispvh.service.serviceImpl;

import org.levi.demomybatispvh.model.Book;
import org.levi.demomybatispvh.model.dto.request.BookRequest;
import org.levi.demomybatispvh.repository.BookRepository;
import org.levi.demomybatispvh.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public Book createBook(BookRequest bookRequest) {
         Integer bookId= bookRepository.insertBook(bookRequest);
         for (Integer categoryId : bookRequest.getCategoryId()){
             bookRepository.insertIntoBookCategory(bookId, categoryId);
         }

         return bookRepository.findBookById(bookId);

    }
}
