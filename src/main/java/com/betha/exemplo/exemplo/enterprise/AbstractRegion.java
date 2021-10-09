package com.betha.exemplo.exemplo.enterprise;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class AbstractRegion extends AbstractEntity {

    @NotNull(message = "O nome não pode ser nulo")
    @Size(max = 12, min = 3)
    @Column(name= "NOME")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "AbstractRegion{" +
                "nome='" + nome +
                '}';
    }
}
