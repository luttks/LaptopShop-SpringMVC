package vn.luthanh.laptopshop.service;

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

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
