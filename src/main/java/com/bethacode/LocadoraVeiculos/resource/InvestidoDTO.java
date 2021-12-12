package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Investido;
import com.bethacode.LocadoraVeiculos.model.Investimento;

import java.time.LocalDate;

public class InvestidoDTO {

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

    public static InvestidoDTO toDTO(Investido investido) {
        InvestidoDTO dto = new InvestidoDTO();
        dto.setValorInvestido(investido.getValorInvestido());
        dto.setDataInvestido(investido.getDataInvestido());
        return dto;
    }

    public static Investido fromDTO(InvestidoDTO dto) {
        Investido entity = new Investido();
        entity.setValorInvestido(dto.getValorInvestido());
        entity.setDataInvestido(dto.getDataInvestido());

        return entity;
    }
}
