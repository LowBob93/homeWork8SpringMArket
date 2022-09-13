package ru.gb.market_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market_back.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}