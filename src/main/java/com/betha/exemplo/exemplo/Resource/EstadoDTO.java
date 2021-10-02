package com.betha.exemplo.exemplo.Resource;

import com.betha.exemplo.exemplo.model.Estado;

public class EstadoDTO {

    private Long id;
    private String nome;

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

    public static EstadoDTO Todto(Estado estado){
        EstadoDTO dto = new EstadoDTO();
        dto.setId(estado.getId());
        dto.setNome(estado.getNome());
        return dto;
    }

    public static Estado fromDto(EstadoDTO dto){
        Estado entity = new Estado();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }


}
