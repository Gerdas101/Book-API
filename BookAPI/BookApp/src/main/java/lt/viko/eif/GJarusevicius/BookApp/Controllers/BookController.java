package lt.viko.eif.GJarusevicius.BookApp.Controllers;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import lt.viko.eif.GJarusevicius.BookApp.Models.UserBook;
import lt.viko.eif.GJarusevicius.BookApp.Services.BookService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {

    BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam("title") String title) throws IOException, ParseException, InterruptedException {
        return bookService.getBooksByTitle(title);
    }
}
