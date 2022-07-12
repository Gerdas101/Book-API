package lt.viko.eif.GJarusevicius.BookApp.Services;

import lt.viko.eif.GJarusevicius.BookApp.Models.User;
import lt.viko.eif.GJarusevicius.BookApp.Repos.UserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public void insert(User user){
        userRepository.save(user);
    }

    public void updateUser(User user, Long id){
        User originalUser = userRepository.findById(id).get();
        originalUser.setUsername(user.getUsername());
        originalUser.setPassword(user.getPassword());
        userRepository.save(originalUser);
    }

    public void deleteUser(Long id){
        userRepository.delete(this.getById(id));
    }




}
