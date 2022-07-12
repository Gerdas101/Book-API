package lt.viko.eif.GJarusevicius.BookApp.Repos;

import lt.viko.eif.GJarusevicius.BookApp.Models.Book;
import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
