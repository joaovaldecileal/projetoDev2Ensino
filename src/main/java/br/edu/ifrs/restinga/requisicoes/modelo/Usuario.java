package br.edu.ifrs.restinga.requisicoes.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//Configurando herança
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "tipo")
//define o tipo raiz
@JsonTypeName("usuario")
//tem que definir as subclasses conhecidas
@JsonSubTypes({
    @JsonSubTypes.Type(name = "aluno", value = Aluno.class),
    @JsonSubTypes.Type(name = "servidor", value = Servidor.class),
    @JsonSubTypes.Type(name = "professor", value = Professor.class)})

public abstract class Usuario implements Serializable {
    
    @JsonProperty("tipo")
    @Transient
    private final String tipo = "usuario";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    @JsonIgnore
    private String senha;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String novaSenha;
    private String email;
    private String permissoes;
    private boolean ativo;
    @Transient
    private String token;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
