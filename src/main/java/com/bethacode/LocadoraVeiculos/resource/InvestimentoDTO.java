package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Cidade;
import com.bethacode.LocadoraVeiculos.model.Cliente;
import com.bethacode.LocadoraVeiculos.model.Investimento;
import com.bethacode.LocadoraVeiculos.model.TipoDocumento;

import java.time.LocalDate;

public class InvestimentoDTO {

    private Double saldo;
    private String parcelas;
    private Double valorInvestido;
    private Double rendimento;

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

/* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }*/

    public static InvestimentoDTO toDTO(Investimento investimento) {
        InvestimentoDTO dto = new InvestimentoDTO();
        dto.setSaldo(investimento.getSaldo());
        dto.setParcelas(investimento.getParcelas());
        dto.setValorInvestido(investimento.getValorInvestido());
        dto.setRendimento(investimento.getRendimento());
        return dto;
    }

    public static Investimento fromDTO(InvestimentoDTO dto) {
        Investimento entity = new Investimento();
        entity.setSaldo(dto.getSaldo());
        entity.setParcelas(dto.getParcelas());
        entity.setValorInvestido(dto.getValorInvestido());
        entity.setRendimento(dto.getRendimento());


        return entity;
    }
}
