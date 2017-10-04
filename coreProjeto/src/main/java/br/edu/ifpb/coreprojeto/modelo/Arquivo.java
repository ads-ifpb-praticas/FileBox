/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author laerton
 */
public class Arquivo {
    private int id, idUser;
    private String endereco;
    private List<Usuario> compartilahdo  = new LinkedList<>();
    private long tamanho;

    public Arquivo(int id, int idUser, String endereco, long tamanho) {
        this.id = id;
        this.idUser = idUser;
        this.endereco = endereco;
        this.tamanho = tamanho;
    }

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }
    


    public List<Usuario> getCompartilahdo() {
        return compartilahdo;
    }

    public void setCompartilahdo(List<Usuario> compartilahdo) {
        this.compartilahdo = compartilahdo;
    }

    
    public void compartilhar (Usuario user){
        this.compartilahdo.add(user);
    }
    
    public void remComparilhar(Usuario user){
        this.compartilahdo.remove(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}
