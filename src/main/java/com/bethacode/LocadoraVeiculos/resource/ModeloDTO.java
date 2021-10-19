package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Marca;
import com.bethacode.LocadoraVeiculos.model.Modelo;
import com.bethacode.LocadoraVeiculos.model.Opcional;

import java.util.List;

public class ModeloDTO {

    private Long id;
    private String nome;
    private String motor;
    private Integer hp;
    private Integer cilindradas;
    private Marca marca;
    private List<Opcional> opcionais;

    public Long getId() {
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

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(Integer cilindradas) {
        this.cilindradas = cilindradas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Opcional> getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(List<Opcional> opcionais) {
        this.opcionais = opcionais;
    }

    public static ModeloDTO toDTO(Modelo modelo) {
        ModeloDTO dto = new ModeloDTO();
        dto.setId(modelo.getId());
        dto.setNome(modelo.getNome());
        dto.setMotor(modelo.getMotor());
        dto.setHp(modelo.getHp());
        dto.setCilindradas(modelo.getCilindradas());
        dto.setMarca(modelo.getMarca());
        dto.setOpcionais(modelo.getOpcionais());
        return dto;
    }

    public static Modelo fromDTO(ModeloDTO dto) {
        Modelo entity = new Modelo();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setMotor(dto.getMotor());
        entity.setHp(dto.getHp());
        entity.setCilindradas(dto.getCilindradas());
        entity.setMarca(dto.getMarca());
        entity.setOpcionais(dto.getOpcionais());
        return entity;
    }
}
