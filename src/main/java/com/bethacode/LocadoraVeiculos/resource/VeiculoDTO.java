package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.*;

public class VeiculoDTO {

    private Long id;
    private Modelo modelo;
    private Cor cor;
    private Tipo tipo;
    private String placa;
    private String renavam;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public static VeiculoDTO toDTO(Veiculo veiculo) {
        VeiculoDTO dto = new VeiculoDTO();
        dto.setId(veiculo.getId());
        dto.setModelo(veiculo.getModelo());
        dto.setCor(veiculo.getCor());
        dto.setPlaca(veiculo.getPlaca());
        dto.setTipo(veiculo.getTipo());
        dto.setRenavam(veiculo.getRenavam());
        return dto;
    }

    public static Veiculo fromDTO(VeiculoDTO dto) {
        Veiculo entity = new Veiculo();
        entity.setId(dto.getId());
        entity.setModelo(dto.getModelo());
        entity.setCor(dto.getCor());
        entity.setPlaca(dto.getPlaca());
        entity.setTipo(dto.getTipo());
        entity.setRenavam(dto.getRenavam());
        return entity;
    }
}
