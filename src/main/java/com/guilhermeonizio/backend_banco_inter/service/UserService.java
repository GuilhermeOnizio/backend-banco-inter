package com.guilhermeonizio.backend_banco_inter.service;

import com.guilhermeonizio.backend_banco_inter.model.User;
import com.guilhermeonizio.backend_banco_inter.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;  // Usando PasswordEncoder em vez de BCryptPasswordEncoder
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Alteração aqui para injetar PasswordEncoder

    @Transactional
    public User cadastrarUsuario(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado!");
        }
        if (userRepository.findByCpf(user.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        // Codificando a senha antes de salvar
        user.setSenha(passwordEncoder.encode(user.getSenha()));  // Usando PasswordEncoder aqui

        // Retornando o usuário após salvar
        return userRepository.save(user);
    }
}