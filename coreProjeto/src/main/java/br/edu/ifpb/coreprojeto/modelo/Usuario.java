/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe cuida dos dados de um usuario.
 * @author laerton
 */
@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 255, nullable = false)
    private String nome;
    @Column(length = 255, nullable = false)
    private String email;
    @Column(length = 255, nullable = false)
    private String senha;
    @OneToMany()
    private List<AbsNode> nodes = new LinkedList<>();
    
    
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    
    public List<AbsNode> getArquivos() {
        return nodes;
    }

    public void setArquivos(List<AbsNode> arquivos) {
        this.nodes = arquivos;
    }
    
    public void addArquivo(AbsNode arquivo){
        this.nodes.add(arquivo);
    }
    
    public void remArquivo(AbsNode arquivo){
        this.nodes.remove(arquivo);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    
}
