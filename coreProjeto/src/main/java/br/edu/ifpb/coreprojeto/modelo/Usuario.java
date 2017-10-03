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
    private int _id;
    private String _nome, email,senha;
    private List<Arquivo> _arquivos = new LinkedList<>();
    
    public Usuario() {
    }

    public Usuario(int _id, String _nome, String email, String senha) {
        this._id = _id;
        this._nome = _nome;
        this.email = email;
        this.senha = senha;
    }

    
    public List<Arquivo> getArquivos() {
        return _arquivos;
    }

    public void setArquivos(List<Arquivo> _arquivos) {
        this._arquivos = _arquivos;
    }
    
    public void addArquivo(Arquivo arquivo){
        this._arquivos.add(arquivo);
    }
    
    public void remArquivo(Arquivo arquivo){
        this._arquivos.remove(arquivo);
    }
    
    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return _nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
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
