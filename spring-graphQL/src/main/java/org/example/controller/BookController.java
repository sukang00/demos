package org.example.controller;

import org.example.entity.Author;
import org.example.entity.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/6 15:28
 */
@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }

    @QueryMapping
    public Author authorById(@Argument String id){
        return Author.getById(id);
    }

    @SchemaMapping
    public List<Book> books(Author author) {
        return Book.getBookByAuthorId(author.getId());
    }
}
