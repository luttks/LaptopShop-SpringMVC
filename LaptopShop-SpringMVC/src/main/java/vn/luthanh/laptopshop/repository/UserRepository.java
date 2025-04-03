package vn.luthanh.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.luthanh.laptopshop.domain.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User newUser);

    List<User> findByEmail(String email);

    List<User> findAll();

    Optional<User> findById(Long id);

    User findById(long id);

    void deleteById(Long id);
}
