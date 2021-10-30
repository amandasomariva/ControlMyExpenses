package com.bethacode.LocadoraVeiculos.model;

import com.bethacode.LocadoraVeiculos.enterprise.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;

@Entity
public class Resumo extends AbstractEntity {
    @NotNull
    private Data dataSaida;
    @NotNull
    private Double valorTotal;
    @NotNull
    private Double saldoTotal;

    @ManyToOne
    @JoinColumn(name = "i_gastos", referencedColumnName = "ID")
    private Gastos gastos;

    public Data getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Data dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Gastos getGastos() {
        return gastos;
    }

    public void setGastos(Gastos gastos) {
        this.gastos = gastos;
    }
}