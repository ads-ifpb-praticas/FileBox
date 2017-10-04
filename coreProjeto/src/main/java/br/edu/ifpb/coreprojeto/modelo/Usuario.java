/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe cuida dos dados de um usuario.
 * @author laerton
 */
public class Usuario {
    private int id;
    private String nome, email , senha;
    private List<Arquivo> arquivos = new LinkedList<>();
    
    
    public Usuario(int id, String _nome, String email, String senha) {
        this.id = id;
        this.nome = _nome;
        this.email = email;
        this.senha = senha;
    }

    
    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }
    
    public void addArquivo(Arquivo arquivo){
        this.arquivos.add(arquivo);
    }
    
    public void remArquivo(Arquivo arquivo){
        this.arquivos.remove(arquivo);
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
