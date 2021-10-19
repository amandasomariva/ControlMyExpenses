package com.bethacode.LocadoraVeiculos.model;


import com.bethacode.LocadoraVeiculos.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Modelo extends AbstractEntity {

    @NotNull
    private String nome;
    private String motor;
    private Integer hp;
    private Integer cilindradas;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "i_marcas", referencedColumnName = "ID")
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "modelo_opcionais",
            joinColumns = {@JoinColumn(name = "modelo_id")},
            inverseJoinColumns = {@JoinColumn(name = "opcionais_id")}
    )
    private List<Opcional> opcionais;

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
}
