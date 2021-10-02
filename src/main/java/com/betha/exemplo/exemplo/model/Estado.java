package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractRegion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estado extends AbstractRegion {

    @ManyToOne
    @JoinColumn(name = "I_PAISES" , referencedColumnName = "ID")
    private Pais pais;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
