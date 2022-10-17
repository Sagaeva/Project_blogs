/*


package be.scrumdilicious.blogOpdracht.services;

import be.scrumdilicious.blogOpdracht.data.User;
import be.scrumdilicious.blogOpdracht.repository.UserRepository;
import be.scrumdilicious.blogOpdracht.security.UserDetailsClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServ implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServ(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new UserDetailsClass(user.get());


    }



}

 */
















