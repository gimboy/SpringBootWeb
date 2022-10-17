package ru.geek.SpringBootWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geek.SpringBootWeb.persist.User;
import ru.geek.SpringBootWeb.persist.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userRepository.save(new User("Artem"));
        this.userRepository.save(new User("Anna"));
        this.userRepository.save(new User("Timur"));
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
