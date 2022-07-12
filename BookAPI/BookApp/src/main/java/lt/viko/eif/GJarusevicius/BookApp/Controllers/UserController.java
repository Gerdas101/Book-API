package lt.viko.eif.GJarusevicius.BookApp.Controllers;

import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserRepository;
import lt.viko.eif.GJarusevicius.BookApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("/")
    public void insertUser(@RequestBody User user){
        userService.insert(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


}
