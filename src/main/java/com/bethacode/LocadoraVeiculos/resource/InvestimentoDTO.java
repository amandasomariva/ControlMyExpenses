package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Investido;
import com.bethacode.LocadoraVeiculos.model.Investimento;

import java.util.List;

public class InvestimentoDTO {

    private Double saldo;
    private String parcelas;
    private Integer rendimento;
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

    public static InvestimentoDTO toDTO(Investimento investimento) {
        InvestimentoDTO dto = new InvestimentoDTO();
        dto.setSaldo(investimento.getSaldo());
        dto.setParcelas(investimento.getParcelas());
        dto.setRendimento(investimento.getRendimento());
        dto.setInvestidos(investimento.getInvestidos());
        return dto;
    }

    public static Investimento fromDTO(InvestimentoDTO dto) {
        Investimento entity = new Investimento();
        entity.setSaldo(dto.getSaldo());
        entity.setParcelas(dto.getParcelas());
        entity.setRendimento(dto.getRendimento());
        entity.setInvestidos(dto.getInvestidos());
        return entity;
    }
}
