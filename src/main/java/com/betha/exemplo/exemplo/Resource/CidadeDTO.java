package com.betha.exemplo.exemplo.Resource;

import com.betha.exemplo.exemplo.model.Cidade;

public class CidadeDTO {

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

    public static CidadeDTO ToDto(Cidade cidade){
        CidadeDTO dto = new CidadeDTO();
        dto.setId(cidade.getId());
        dto.setNome(cidade.getNome());
        return dto;
    }

    public static Cidade fromDto(CidadeDTO dto){
        Cidade entity = new Cidade();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }
}
