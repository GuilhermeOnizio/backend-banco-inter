package com.guilhermeonizio.backend_banco_inter.repository;

import com.guilhermeonizio.backend_banco_inter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);
}
