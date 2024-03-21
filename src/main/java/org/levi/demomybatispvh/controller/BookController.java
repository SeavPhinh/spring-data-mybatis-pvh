package org.levi.demomybatispvh.controller;

import org.levi.demomybatispvh.model.Book;
import org.levi.demomybatispvh.model.dto.ApiResponse;
import org.levi.demomybatispvh.model.dto.request.BookRequest;
import org.levi.demomybatispvh.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBook(){
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.ok(new ApiResponse<>(
                "successfully",
                HttpStatus.OK,
                200,
                books
        ));
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest){
        Book books = bookService.createBook(bookRequest);
        return ResponseEntity.ok(new ApiResponse<>(
                "successfully created book",
                HttpStatus.OK,
                200,
                books
        ));
    }

}
