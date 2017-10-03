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
    private int _id, _idUser;
    private String _endereco;
    private List<Usuario> _compartilahdo  = new LinkedList<>();

    public Arquivo(int _id, int _idUser, String _endereco) {
        this._id = _id;
        this._idUser = _idUser;
        this._endereco = _endereco;
    }

    public Arquivo() {
    }

    public List<Usuario> getCompartilahdo() {
        return _compartilahdo;
    }

    public void setCompartilahdo(List<Usuario> _compartilahdo) {
        this._compartilahdo = _compartilahdo;
    }

    
    public void compartilhar (Usuario user){
        this._compartilahdo.add(user);
    }
    
    public void remComparilhar(Usuario user){
        this._compartilahdo.remove(user);
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getEndereco() {
        return _endereco;
    }

    public void setEndereco(String _endereco) {
        this._endereco = _endereco;
    }

    public int getIdUser() {
        return _idUser;
    }

    public void setIdUser(int _idUser) {
        this._idUser = _idUser;
    }
    
}
