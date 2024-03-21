package org.levi.demomybatispvh.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.levi.demomybatispvh.model.Author;
import org.levi.demomybatispvh.model.dto.request.AuthorRequest;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();
    Author getAuthorById(Integer id) throws NotFoundException;
    Author insertAuthor(AuthorRequest authorRequest);
    void updateAuthor(Integer id, AuthorRequest authorRequest) throws NotFoundException;
    void deleteAuthor(Integer id) throws NotFoundException;
}
