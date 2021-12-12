package com.bethacode.LocadoraVeiculos.model;

import com.bethacode.LocadoraVeiculos.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Investimento extends AbstractEntity {
    @NotNull
    private Double saldo;
    @NotNull
    private String parcelas;
    @NotNull
    private Integer rendimento;

    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "investimento_investidos",
            joinColumns = {@JoinColumn(name = "investimento_id")},
            inverseJoinColumns = {@JoinColumn(name = "investidos_id")}
    )
    private List<Investido> investidos;

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public Integer getRendimento() {
        return rendimento;
    }

    public void setRendimento(Integer rendimento) {
        this.rendimento = rendimento;
    }

    public List<Investido> getInvestidos() {
        return investidos;
    }

    public void setInvestidos(List<Investido> investidos) {
        this.investidos = investidos;
    }
}