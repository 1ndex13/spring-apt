package com.start.egor.library.controller;

import com.start.egor.library.model.Author;
import com.start.egor.library.model.Book;
import com.start.egor.library.repository.AuthorRepository;
import com.start.egor.library.repository.BookRepository;
import com.start.egor.library.repository.GenericRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/authors")
@Tag(name = "Авторы", description = "Контроллер для работы с авторами из библиотеки")
public class AuthorController extends GenericController<Author>  {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    protected AuthorController(GenericRepository<Author> genericRepository, AuthorRepository authorRepository,
                               BookRepository bookRepository) {
        super(genericRepository);
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Operation(description = "Добавить книгу к автору")
    @RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> addBook(@RequestParam(value = "bookId") Long bookId,
                                          @RequestParam(value = "authorId") Long authorId){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена"));
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Автор не найден"));
        author.getBooks().add(book);
        return ResponseEntity.status(HttpStatus.OK).body(authorRepository.save(author));
    }
}
