package org.levi.demomybatispvh.repository;

import org.apache.ibatis.annotations.*;
import org.levi.demomybatispvh.model.Author;
import org.levi.demomybatispvh.model.dto.request.AuthorRequest;

import java.util.List;

@Mapper
public interface AuthorRepository {

    @Select("""
    SELECT * FROM authors
    """)
    @Results(id = "authorMapping", value = {
            @Result(property = "authorName", column = "author_name"),
    })
    List<Author> findAllAuthor();

    @Select("""
    SELECT * FROM authors
    WHERE id = #{id}
    """)
    @ResultMap("authorMapping")
    Author findByAuthorId(Integer id);

    @Select("""
    INSERT INTO authors (author_name, gender)
    VALUES (#{author.authorName}, #{author.gender})
    RETURNING *
    """)
    @ResultMap("authorMapping")
    Author insertAuthor(@Param("author") AuthorRequest authorRequest);


    @Update("""
    UPDATE authors
    SET author_name= #{author.authorName}, gender = #{author.gender}
    WHERE id = #{id}
    """)
    void updateAuthorById(Integer id, @Param("author") AuthorRequest authorRequest);

    @Delete("""
            DELETE FROM authors
            WHERE id = #{id}
            """)
    void deleteAuthorById(Integer id);
}
