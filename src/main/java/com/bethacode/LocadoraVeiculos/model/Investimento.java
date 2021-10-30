package com.bethacode.LocadoraVeiculos.model;

import com.bethacode.LocadoraVeiculos.enterprise.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Investimento extends AbstractEntity {
    @NotNull
    private Double saldo;
    @NotNull
    private String parcelas;
    @NotNull
    private Double valorInvestido;
    @NotNull
    private Double rendimento;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "i_gastos", referencedColumnName = "ID")
    private Gastos gastos;

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

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public Double getRendimento() {
        return rendimento;
    }

    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }

    public Gastos getGastos() {
        return gastos;
    }

    public void setGastos(Gastos gastos) {
        this.gastos = gastos;
    }
}