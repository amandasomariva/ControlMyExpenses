package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;
import com.betha.exemplo.exemplo.enterprise.IPublicavel;

public class Curtida extends AbstractEntity {

    private ContaUsuario contaUsuario;
    private IPublicavel publicacao;

    public ContaUsuario getContaUsuario() {
        return contaUsuario;
    }

    public void setContaUsuario(ContaUsuario contaUsuario) {
        this.contaUsuario = contaUsuario;
    }

    public IPublicavel getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(IPublicavel publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public String toString() {
        return "Curtida{" +
                "contaUsuario=" + contaUsuario +
                ", publicacao=" + publicacao +
                '}';
    }
}
