package vn.luthanh.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.luthanh.laptopshop.domain.User;
import vn.luthanh.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "Hello from User Service";
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUserByEmail(String email) {
        return this.userRepository.findByEmail(email);

    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
