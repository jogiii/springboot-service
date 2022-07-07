package com.example.product.repositories;

import com.example.product.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>
{
    List findByTitleContaining(String title);
    List findByAuthor(String name);
}
