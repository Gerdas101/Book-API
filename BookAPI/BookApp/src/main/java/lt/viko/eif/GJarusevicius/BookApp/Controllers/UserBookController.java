package lt.viko.eif.GJarusevicius.BookApp.Controllers;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import lt.viko.eif.GJarusevicius.BookApp.Models.UserBook;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserBookRepository;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserRepository;
import lt.viko.eif.GJarusevicius.BookApp.Services.BookService;
import lt.viko.eif.GJarusevicius.BookApp.Services.UserBookService;
import lt.viko.eif.GJarusevicius.BookApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-books")
public class UserBookController {

    UserService userService;
    UserBookService userBookService;

    @Autowired
    UserBookController(UserService userService, UserBookService userBookService){
        this.userService = userService;
        this.userBookService = userBookService;
    }




    @PostMapping("/{userId}")
    public void insertBook(@PathVariable Long userId,
                           @RequestParam("pagesRead") int pagesRead,
                           @RequestParam("notes") String notes,
                           @RequestBody Book book){
        boolean isFinished;
        isFinished = pagesRead >= book.getPages();

        User user = userService.getById(userId);
        if(user == null){
            System.out.println("User not found...");
        }else {
            Book userBook = new UserBook(
                book.getId(),
                book.getTitle(),
                book.getPages(),
                book.getAuthorList(),
                book.getPublishedDate(),
                book.getDescription(),
                pagesRead, notes, isFinished, user);
                userBookService.saveBook(userBook);
                System.out.println("Book inserted...");
        }
    }

}
