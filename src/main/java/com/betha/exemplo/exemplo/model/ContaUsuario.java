package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class ContaUsuario extends AbstractEntity {

    @NotNull(message = "O apelido não pode ser nulo")
    @Size(min = 25)
    @Column(name = "APELIDO")
    private String nomeConta;
    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 200)
    @Column(name = "NOME")
    private String nomeCompleto;
    @NotNull(message = "A data não pode ser nulo")
    @Column(name = "DATA_NASC")
    private LocalDate dataNascimento;
    @NotNull(message = "A data não pode ser nulo")
    @Column(name = "DATA_CRIA")
    private LocalDate dataCriacaoConta;
    @NotNull(message = "A biografia não pode ser nulo")
    @Max(value = 500)
    @Column(name = "BIOGRAFIA")
    private String biografia;
    @NotNull(message = "O link não pode ser nulo")
    @Max(value = 100)
    @Column(name = "LINK")
    private String link;



    @ManyToOne
    @JoinColumn(name = "I_CIDADES" , referencedColumnName = "ID")
    private Cidade cidade;
    @Transient
    private Set<Feed> publicacoes;
    @Transient
    private Set<Historia> historias;
    @Transient
    private Set<ContaUsuario> seguidores;
    @Transient
    private Set<ContaUsuario> seguindo;

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

   // public String getDataCriacaoConta() {
       // return dataCriacaoConta;
  //  }

    public void setDataCriacaoConta(LocalDate dataCriacaoConta) {
        this.dataCriacaoConta = dataCriacaoConta;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Set<Feed> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(Set<Feed> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public Set<Historia> getHistorias() {
        return historias;
    }

    public void setHistorias(Set<Historia> historias) {
        this.historias = historias;
    }

    public Set<ContaUsuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Set<ContaUsuario> seguidores) {
        this.seguidores = seguidores;
    }

    public Set<ContaUsuario> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(Set<ContaUsuario> seguindo) {
        this.seguindo = seguindo;
    }

    @Override
    public String toString() {
        return "ContaUsuario{" +
                "nomeConta='" + nomeConta + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                '}';
    }
}
