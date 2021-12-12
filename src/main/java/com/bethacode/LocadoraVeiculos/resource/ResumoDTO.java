package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Investimento;
import com.bethacode.LocadoraVeiculos.model.Resumo;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public class ResumoDTO {

    private LocalDate dataSaida;
    private Double valorTotal;
    private Double saldoTotal;

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
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

    public static ResumoDTO toDTO(Resumo resumo) {
        ResumoDTO dto = new ResumoDTO();
        dto.setDataSaida(resumo.getDataSaida());
        dto.setValorTotal(resumo.getValorTotal());
        dto.setSaldoTotal(resumo.getSaldoTotal());

        return dto;
    }

    public static Resumo fromDTO(ResumoDTO dto) {
        Resumo entity = new Resumo();
        entity.setDataSaida(dto.getDataSaida());
        entity.setValorTotal(dto.getValorTotal());
        entity.setSaldoTotal(dto.getSaldoTotal());



        return entity;
    }
}
