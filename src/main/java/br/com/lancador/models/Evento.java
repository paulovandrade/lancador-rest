package br.com.lancador.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by paulo on 09/07/16.
 */
@Entity
@Table(name = "evento")
public class Evento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idevento")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "url")
    private String url;

    @Column(name = "icone")
    private String icone;

    @NotNull
    @Column(name = "ativa")
    private Character ativa = new Character('S');

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) { this.url = url; }

    public String getIcone() { return icone; }

    public void setIcone(String icone) { this.icone = icone; }

    public Character getAtiva() {
        return ativa;
    }

    public void setAtiva(Character ativa) {
        this.ativa = ativa;
    }
}
