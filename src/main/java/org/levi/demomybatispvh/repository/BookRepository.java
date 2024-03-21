package org.levi.demomybatispvh.repository;

import org.apache.ibatis.annotations.*;
import org.levi.demomybatispvh.model.Book;
import org.levi.demomybatispvh.model.Category;
import org.levi.demomybatispvh.model.dto.request.BookRequest;

import java.util.List;

@Mapper
public interface BookRepository {

    @Select("""
    SELECT * FROM books
    """)
    @Results(id = "bookMapping", value = {
            @Result(property = "publishedDate", column = "published_date"),
            @Result(property = "author", column = "author_id",
            one = @One(select = "org.levi.demomybatispvh.repository.AuthorRepository.findByAuthorId")
            ),
            @Result(property = "id", column = "id"),
            @Result(property = "categories", column = "id",
            many = @Many(select = "org.levi.demomybatispvh.repository.CategoryRepository.getAllCategoryByBookId"))
    })
    List<Book> getAllBook();

    @Select("""
    INSERT INTO books (title, published_date, author_id)
    VALUES (#{book.title}, #{book.publishedDate}, #{book.authorId})
    RETURNING id;
    """)
    Integer insertBook(@Param("book") BookRequest bookRequest);

    @Insert("""
    INSERT INTO book_category
    VALUES (#{bookId}, #{categoryId})
    """)
    void insertIntoBookCategory(Integer bookId, Integer categoryId);

    @Select("""
    SELECT * FROM books
    WHERE id = #{bookId}
    """)
    @ResultMap("bookMapping")
    Book findBookById(Integer bookId);
}
