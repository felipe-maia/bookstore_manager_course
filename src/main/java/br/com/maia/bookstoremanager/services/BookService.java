package br.com.maia.bookstoremanager.services;

import br.com.maia.bookstoremanager.dto.BookDTO;
import br.com.maia.bookstoremanager.dto.MessageResponseDTO;
import br.com.maia.bookstoremanager.entity.Book;
import br.com.maia.bookstoremanager.exception.BookNotFoundException;
import br.com.maia.bookstoremanager.mapper.BookMapper;
import br.com.maia.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Locale;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){

        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder().message("Book created with ID:"+savedBook.getId()).
                build();
    }


    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
