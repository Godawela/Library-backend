package com.gl.lms.service;

import com.gl.lms.entity.Books;
import com.gl.lms.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    // Update a book by ID
    public Books update(Integer id, Books book) {
        Optional<Books> existingBook = booksRepository.findById(id);

        if (existingBook.isPresent()) {
            Books b = existingBook.get();
            b.setTitle(book.getTitle());
            // add other fields as needed
            return booksRepository.save(b);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    // Delete a book by ID
    public void delete(Integer id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}
