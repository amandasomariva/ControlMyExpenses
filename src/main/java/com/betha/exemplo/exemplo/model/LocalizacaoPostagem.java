package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;

public class LocalizacaoPostagem extends AbstractEntity {
    /*
     * Analisar melhor forma de criar a localização dinamica
     * */
    private Pais pais;
    private Estado estado;
    private Cidade cidade;
    private String descricaoLocal;

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    public String getDescricaoLocal() {
        if (descricaoLocal == null) {
            if (pais != null) {
                descricaoLocal += pais.getNome();
            }
            if (estado != null) {
                descricaoLocal += estado.getNome();
            }
            if (cidade != null) {
                descricaoLocal += cidade.getNome();
            }
        }
        return descricaoLocal;
    }

    @Override
    public String toString() {
        return "LocalizacaoPostagem{" +
                "descricaoLocal='" + descricaoLocal + '\'' +
                '}';
    }
}
