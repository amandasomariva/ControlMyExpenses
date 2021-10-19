package com.bethacode.LocadoraVeiculos.model;

import com.bethacode.LocadoraVeiculos.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pais extends AbstractRegion {

    @Column(name = "INDICE_DESENV_HUM")
    private Integer idh;

    public Integer getIdh() {
        return idh;
    }

    public void setIdh(Integer idh) {
        this.idh = idh;
    }
}
