package org.levi.demomybatispvh.service.serviceImpl;

import org.apache.ibatis.javassist.NotFoundException;
import org.levi.demomybatispvh.model.Author;
import org.levi.demomybatispvh.model.dto.request.AuthorRequest;
import org.levi.demomybatispvh.repository.AuthorRepository;
import org.levi.demomybatispvh.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAllAuthor();
    }

    @Override
    public Author getAuthorById(Integer id) throws NotFoundException {
        if (authorRepository.findByAuthorId(id) == null){
            throw new NotFoundException("Author does not exist");
        }
        return authorRepository.findByAuthorId(id);
    }

    @Override
    public Author insertAuthor(AuthorRequest authorRequest) {
        return authorRepository.insertAuthor(authorRequest);
    }

    @Override
    public void updateAuthor(Integer id, AuthorRequest authorRequest) throws NotFoundException {
        if (authorRepository.findByAuthorId(id) == null){
            throw new NotFoundException("Author does not exist");
        }
        authorRepository.updateAuthorById(id, authorRequest);
    }

    @Override
    public void deleteAuthor(Integer id) throws NotFoundException {
        if (authorRepository.findByAuthorId(id) == null){
            throw new NotFoundException("Author does not exist");
        }
        authorRepository.deleteAuthorById(id);
    }
}
