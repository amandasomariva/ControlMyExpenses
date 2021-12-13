package com.bethacode.LocadoraVeiculos.resource;



import com.bethacode.LocadoraVeiculos.model.Gasto;
import com.bethacode.LocadoraVeiculos.model.TipoDespesa;
import com.bethacode.LocadoraVeiculos.model.TipoPagamento;

import java.time.LocalDate;

public class GastoDTO {

    private String id;
    private String descricaoCompra;
    private Double valorCompra;
    private LocalDate dataCompra;
    private LocalDate dataVencimento;
    private TipoPagamento tipoPagamento;
    private TipoDespesa tipoDespesa;
    private boolean pago;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricaoCompra() {
        return descricaoCompra;
    }

    public void setDescricaoCompra(String descricaoCompra) {
        this.descricaoCompra = descricaoCompra;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public static GastoDTO toDTO(Gasto gasto) {
        GastoDTO dto = new GastoDTO();
        dto.setId(gasto.getId().toString());
        dto.setDescricaoCompra(gasto.getDescricaoCompra());
        dto.setValorCompra(gasto.getValorCompra());
        dto.setDataCompra(gasto.getDataCompra());
        dto.setDataVencimento(gasto.getDataVencimento());
        dto.setTipoPagamento(gasto.getTipoPagamento());
        dto.setTipoDespesa(gasto.getTipoDespesa());
        dto.setPago(gasto.isPago());
        return dto;
    }

    public static Gasto fromDTO(GastoDTO dto) {
        Gasto entity = new Gasto();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricaoCompra(dto.getDescricaoCompra());
        entity.setValorCompra(dto.getValorCompra());
        entity.setDataCompra(dto.getDataCompra());
        entity.setDataVencimento(dto.getDataVencimento());
        entity.setTipoPagamento(dto.getTipoPagamento());
        entity.setTipoDespesa(dto.getTipoDespesa());
        entity.setPago(dto.isPago());

        return entity;
    }
}