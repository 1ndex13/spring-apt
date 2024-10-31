package com.start.egor.library.controller;

import com.start.egor.library.model.BookRentInfo;
import com.start.egor.library.repository.GenericRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rent/info")
@Tag(name = "Контроллер для работы с арендами книг")
@RestController
public class BookRentInfoConroller extends GenericController<BookRentInfo> {
    public BookRentInfoConroller(GenericRepository<BookRentInfo> genericRepository) {
        super(genericRepository);
    }
}
