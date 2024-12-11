package com.guilhermeonizio.backend_banco_inter.controller;

import com.guilhermeonizio.backend_banco_inter.model.User;
import com.guilhermeonizio.backend_banco_inter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User user) {
        User usuarioCriado = userService.cadastrarUsuario(user);
        return ResponseEntity.ok(usuarioCriado);
    }
}
