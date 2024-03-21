package org.levi.demomybatispvh.controller;

import org.apache.ibatis.javassist.NotFoundException;
import org.levi.demomybatispvh.model.dto.ApiResponse;
import org.levi.demomybatispvh.model.Author;
import org.levi.demomybatispvh.model.dto.request.AuthorRequest;
import org.levi.demomybatispvh.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthor(){
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer id) throws NotFoundException {
        Author author = authorService.getAuthorById(id);
        ApiResponse<Author> response = new ApiResponse<>(
                "successfully get author",
                HttpStatus.OK,
                200,
                author
        );
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<?> insertAuthor(@RequestBody AuthorRequest authorRequest){
        Author author = authorService.insertAuthor(authorRequest);
        ApiResponse<Author> response = new ApiResponse<>(
                "successfully insert author",
                HttpStatus.CREATED,
                201,
                author
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id,
                                          @RequestBody AuthorRequest authorRequest) throws NotFoundException {
        authorService.updateAuthor(id,authorRequest);
        ApiResponse<Author> response = new ApiResponse<>(
                "successfully update author",
                HttpStatus.OK,
                200,
                null
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<?> deleteAuthorById(@PathVariable Integer id) throws NotFoundException {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok(new ApiResponse<>(
                "successfully delete author",
                HttpStatus.OK,
                200,
                null
        ));
    }

}
