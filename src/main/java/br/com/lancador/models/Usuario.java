package br.com.lancador.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by paulo on 09/07/16.
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "senha")
    private String senha;

    @NotNull
    @Column(name = "admin")
    private Character admin = new Character('N');

    @NotNull
    @Column(name = "ativo")
    private Character ativo = new Character('S');

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "ultimoacesso")
    private Date ultimoAcesso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getAdmin() { return admin; }

    public void setAdmin(Character admin) { this.admin = admin; }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) { this.ultimoAcesso = ultimoAcesso; }
}
