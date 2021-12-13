package com.bethacode.LocadoraVeiculos.resource;



import com.bethacode.LocadoraVeiculos.model.Sexo;
import com.bethacode.LocadoraVeiculos.model.Usuario;

import java.time.LocalDate;

public class UsuarioDTO {

    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String cpf;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId().toString());
        dto.setNome(usuario.getNome());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setSexo(usuario.getSexo());
        dto.setCpf(usuario.getCpf());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    public static Usuario fromDTO(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setId(Long.getLong(dto.getId()));
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSexo(dto.getSexo());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());

        return entity;
    }
}