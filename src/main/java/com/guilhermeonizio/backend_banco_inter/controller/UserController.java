package com.guilhermeonizio.backend_banco_inter.controller;

import com.guilhermeonizio.backend_banco_inter.model.User;
import com.guilhermeonizio.backend_banco_inter.service.UserService;
import com.guilhermeonizio.backend_banco_inter.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransferenciaService transferenciaService;

    // Endpoint para consultar saldo
    @GetMapping("/{id}/saldo")
    public double consultarSaldo(@PathVariable Long id) {
        User user = userService.consultarSaldo(id);
        return user.getSaldo();
    }

    // Endpoint para adicionar saldo
    @PutMapping("/{id}/saldo")
    public User adicionarSaldo(@PathVariable Long id, @RequestParam double valor) {
        return userService.adicionarSaldo(id, valor);
    }

    // Endpoint para transferir saldo
    @PostMapping("/transferir")
    public String transferir(@RequestParam Long deUsuarioId, @RequestParam Long paraUsuarioId, @RequestParam double valor) {
        return transferenciaService.transferir(deUsuarioId, paraUsuarioId, valor);
    }
}
