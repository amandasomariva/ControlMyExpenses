package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Marca;

public class MarcaDTO {
    private Long id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static MarcaDTO toDTO(Marca marca) {
        MarcaDTO dto = new MarcaDTO();
        dto.setId(marca.getId());
        dto.setNome(marca.getNome());
        return dto;
    }

    public static Marca fromDTO(MarcaDTO dto) {
        Marca entity = new Marca();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }
}
