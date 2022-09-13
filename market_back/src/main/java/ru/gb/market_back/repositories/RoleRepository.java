package ru.gb.market_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market_back.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}