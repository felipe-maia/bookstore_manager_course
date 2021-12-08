package br.com.maia.bookstoremanager.controller;

import br.com.maia.bookstoremanager.dto.BookDTO;
import br.com.maia.bookstoremanager.dto.MessageResponseDTO;
import br.com.maia.bookstoremanager.entity.Book;
import br.com.maia.bookstoremanager.exception.BookNotFoundException;
import br.com.maia.bookstoremanager.repository.BookRepository;
import br.com.maia.bookstoremanager.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

}
