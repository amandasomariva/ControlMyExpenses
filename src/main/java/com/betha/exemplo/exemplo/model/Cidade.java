package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends AbstractRegion {

    @Column(name = "IDH")
    private Long idh;
    @Column(name = "NOME_PREFEITO")
    private String nomePrefeito;

    @ManyToOne
    @JoinColumn(name = "I_ESTADO" , referencedColumnName = "ID")
    private Estado estado;

    public Long getIdh() {
        return idh;
    }

    public void setIdh(Long idh) {
        this.idh = idh;
    }

    public String getNomePrefeito() {
        return nomePrefeito;
    }

    public void setNomePrefeito(String nomePrefeito) {
        this.nomePrefeito = nomePrefeito;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
