package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;
import com.betha.exemplo.exemplo.enterprise.IPublicavel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

import java.time.LocalDate;

@Entity
@Table(name = "FEEDS")
public class Feed extends AbstractEntity implements IPublicavel {

    @ManyToOne
    @JoinColumn(name = "I_CTAS_USUARIOS",
            referencedColumnName = "ID")
    private ContaUsuario contaUsuario;
    @Column(name = "TIPO")
    private TipoPublicacao tipoPublicacao;
    @Column(name = "LINK")
    private String linkPublicacaoS3;
    @Column(name = "DATA")
    private LocalDate dataPublicacao;
    @NotNull
    //@Size(max = 12, min = 3)
    @Column(name = "TEXTO")
    private String textoPublicacao;
    @Transient
    private Set<Comentario> comentarios;
    @Transient
    private Set<Curtida> curtidas;
    @Transient
    private LocalizacaoPostagem localizacaoPostagem;

    public ContaUsuario getContaUsuario() {
        return contaUsuario;
    }

    public void setContaUsuario(ContaUsuario contaUsuario) {
        this.contaUsuario = contaUsuario;
    }

    public TipoPublicacao getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(TipoPublicacao tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public String getLinkPublicacaoS3() {
        return linkPublicacaoS3;
    }

    public void setLinkPublicacaoS3(String linkPublicacaoS3) {
        this.linkPublicacaoS3 = linkPublicacaoS3;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTextoPublicacao() {
        return textoPublicacao;
    }

    public void setTextoPublicacao(String textoPublicacao) {
        this.textoPublicacao = textoPublicacao;
    }

    @Override
    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Set<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public LocalizacaoPostagem getLocalizacaoPostagem() {
        return localizacaoPostagem;
    }

    public void setLocalizacaoPostagem(LocalizacaoPostagem localizacaoPostagem) {
        this.localizacaoPostagem = localizacaoPostagem;
    }

    @Override
    public String toString() {
        return "Feed{" +
                ", tipoPublicacao=" + tipoPublicacao +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }

    @Override
    public ContaUsuario getUsuarioPublicou() {
        return this.contaUsuario;
    }
}
