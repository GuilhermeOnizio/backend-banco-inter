package com.guilhermeonizio.backend_banco_inter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deUsuarioId;
    private Long paraUsuarioId;
    private double valor;

    private LocalDateTime dataHora;

    @ManyToOne
    private User usuarioOrigem;

    @ManyToOne
    private User usuarioDestino;

    public Transacao(Long deUsuarioId, Long paraUsuarioId, double valor, User usuarioOrigem, User usuarioDestino) {
        this.deUsuarioId = deUsuarioId;
        this.paraUsuarioId = paraUsuarioId;
        this.valor = valor;
        this.usuarioOrigem = usuarioOrigem;
        this.usuarioDestino = usuarioDestino;
        this.dataHora = LocalDateTime.now(); // Atribuindo a data/hora da transação
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeUsuarioId() {
        return deUsuarioId;
    }

    public void setDeUsuarioId(Long deUsuarioId) {
        this.deUsuarioId = deUsuarioId;
    }

    public Long getParaUsuarioId() {
        return paraUsuarioId;
    }

    public void setParaUsuarioId(Long paraUsuarioId) {
        this.paraUsuarioId = paraUsuarioId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public User getUsuarioOrigem() {
        return usuarioOrigem;
    }

    public void setUsuarioOrigem(User usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

    public User getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(User usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }
}
