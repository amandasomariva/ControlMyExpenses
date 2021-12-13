package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Investido;
import com.bethacode.LocadoraVeiculos.model.Investimento;

import java.util.List;

public class InvestimentoDTO {

    private String id;
    private Double saldo;
    private Integer parcelas;
    private Integer rendimento;
    private List<Investido> investidos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
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



    public static InvestimentoDTO toDTO(Investimento investimento) {
        InvestimentoDTO dto = new InvestimentoDTO();
        dto.setId(investimento.getId().toString());
        dto.setSaldo(investimento.getSaldo());
        dto.setParcelas(investimento.getParcelas());
        dto.setRendimento(investimento.getRendimento());
        dto.setInvestidos(investimento.getInvestidos());
        return dto;
    }

    public static Investimento fromDTO(InvestimentoDTO dto) {
        Investimento entity = new Investimento();
        entity.setId(Long.getLong(dto.getId()));
        entity.setSaldo(dto.getSaldo());
        entity.setParcelas(dto.getParcelas());
        entity.setRendimento(dto.getRendimento());
        entity.setInvestidos(dto.getInvestidos());
        return entity;
    }
}
