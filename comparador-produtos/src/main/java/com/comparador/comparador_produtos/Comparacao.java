package com.comparador.comparador_produtos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comparacao")
public class Comparacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer usuarioId;
    private LocalDateTime dataHora;

    public Comparacao() {
        this.dataHora = LocalDateTime.now();
    }

    public int getId() { return id; }
    public Integer getUsuarioId() { return usuarioId; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}