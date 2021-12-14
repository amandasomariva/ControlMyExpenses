package com.bethacode.LocadoraVeiculos.model;

import com.bethacode.LocadoraVeiculos.enterprise.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Investido extends AbstractEntity {

    private Double valorInvestido;

    private LocalDate dataInvestido;

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public LocalDate getDataInvestido() {
        return dataInvestido;
    }

    public void setDataInvestido(LocalDate dataInvestido) {
        this.dataInvestido = dataInvestido;
    }
}