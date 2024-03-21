package org.levi.demomybatispvh.repository;

import org.apache.ibatis.annotations.*;
import org.levi.demomybatispvh.model.Book;
import org.levi.demomybatispvh.model.Category;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @Select("""
    SELECT c.category_name FROM categories c
    JOIN book_category bc ON c.id = bc.category_id
    WHERE bc.book_id = #{id}
    """)
    @Result(property = "categoryName", column = "category_name")
    List<String> getAllCategoryByBookId(Integer id);

}
