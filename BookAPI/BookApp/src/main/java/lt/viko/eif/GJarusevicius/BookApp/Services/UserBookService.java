package lt.viko.eif.GJarusevicius.BookApp.Services;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import lt.viko.eif.GJarusevicius.BookApp.Models.UserBook;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserBookService {

    UserBookRepository userBookRepository;

    @Autowired
    UserBookService(UserBookRepository userBookRepository){
        this.userBookRepository = userBookRepository;
    }

    public Book saveBook(Book userBook){
        return userBookRepository.save(userBook);
    }
}
