package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Marca;
import com.bethacode.LocadoraVeiculos.model.Opcional;

public class OpcionalDTO {

    private Long id;
    private String nome;
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static OpcionalDTO toDTO(Opcional opcional) {
        OpcionalDTO dto = new OpcionalDTO();
        dto.setId(opcional.getId());
        dto.setNome(opcional.getNome());
        dto.setDescricao(opcional.getDescricao());
        return dto;
    }

    public static Opcional fromDTO(OpcionalDTO dto) {
        Opcional entity = new Opcional();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
