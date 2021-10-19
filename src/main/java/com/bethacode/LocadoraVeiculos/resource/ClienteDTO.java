package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.model.Cidade;
import com.bethacode.LocadoraVeiculos.model.Cliente;
import com.bethacode.LocadoraVeiculos.model.Estado;
import com.bethacode.LocadoraVeiculos.model.TipoDocumento;

import java.time.LocalDate;

public class ClienteDTO {

    private Long id;
    private String nome;
    private TipoDocumento tipoDocumento;
    private String documento;
    private LocalDate dataNascimento;
    private Cidade cidade;

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
    }

    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTipoDocumento(cliente.getTipoDocumento());
        dto.setDocumento(cliente.getDocumento());
        dto.setDataNascimento(cliente.getDataNascimento());
        dto.setCidade(cliente.getCidade());
        return dto;
    }

    public static Cliente fromDTO(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setDocumento(dto.getDocumento());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCidade(dto.getCidade());

        return entity;
    }
}
