package com.guilhermeonizio.backend_banco_inter.service;

import com.guilhermeonizio.backend_banco_inter.model.Transacao;
import com.guilhermeonizio.backend_banco_inter.model.User;
import com.guilhermeonizio.backend_banco_inter.repository.TransacaoRepository;
import com.guilhermeonizio.backend_banco_inter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public String transferir(Long deUsuarioId, Long paraUsuarioId, double valor) {
        User deUsuario = userRepository.findById(deUsuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário de origem não encontrado"));
        User paraUsuario = userRepository.findById(paraUsuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário de destino não encontrado"));

        if (deUsuario.getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }

        if (valor <= 0) {
            throw new RuntimeException("O valor da transferência deve ser positivo");
        }

        // Atualizando saldo dos usuários
        deUsuario.setSaldo(deUsuario.getSaldo() - valor);
        paraUsuario.setSaldo(paraUsuario.getSaldo() + valor);

        // Salvando os usuários com os saldos atualizados
        userRepository.save(deUsuario);
        userRepository.save(paraUsuario);

        // Criando transação
        Transacao transacao = new Transacao(deUsuarioId, paraUsuarioId, valor, deUsuario, paraUsuario);
        transacaoRepository.save(transacao);

        return "Transferência realizada com sucesso!";
    }
}
