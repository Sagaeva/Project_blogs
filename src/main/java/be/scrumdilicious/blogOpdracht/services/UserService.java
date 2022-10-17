package be.scrumdilicious.blogOpdracht.services;

import be.scrumdilicious.blogOpdracht.data.ERole;
import be.scrumdilicious.blogOpdracht.data.Post;
import be.scrumdilicious.blogOpdracht.data.User;
import be.scrumdilicious.blogOpdracht.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User createUser(User user) {

        return userRepository.save(user);
    }



    public User getCurrentUser(String username) {
        Optional user = userRepository.findUserByUsername(username);
        if (user.isPresent()) {
            return (User) user.get();
        }
        return null;



    }

    public List<User> getAllUsers() {
      return userRepository.findAll();
    }
}
