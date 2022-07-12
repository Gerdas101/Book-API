package lt.viko.eif.GJarusevicius.BookApp.Repos;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BookRepository extends JpaRepository<Book, String> {
}
