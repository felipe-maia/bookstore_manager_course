package br.com.maia.bookstoremanager.repository;

import br.com.maia.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Book,Long> {
}
