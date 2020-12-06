package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ronnen on 2020-12-06.
 */

// This is a Spring managed class, hence will autowire 'bookRepository'
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        // 'model' comes from 'springframework.ui'
        // provided by the framework to the class.
        // Adding here an attribute to it (List of books)
        model.addAttribute("books", bookRepository.findAll());

        // returning a view named 'books'
        return "books";
    }
}
