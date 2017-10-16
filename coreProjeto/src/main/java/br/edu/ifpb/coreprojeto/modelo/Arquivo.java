/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe relacionada a um arquivo.
 * @author laerton
 */

public class Arquivo extends AbsNode{


    public Arquivo() {
        super.type = TypeNode.ARQUIVO;
    }

    @Override
    public void setTamanho(Integer tamanho) {
        super.tamanho =tamanho;
    }

    @Override
    public Integer getTamanho() {
        return super.tamanho;
    }

    @Override
    public List<Usuario> getCompartilhado() {
        return super.compartilahdo;
    }

    @Override
    public void setCompartilhado(List<Usuario> usuarios) {
        super.compartilahdo=usuarios;
    }

    @Override
    public void addCompartilhado(Usuario user) {
        super.compartilahdo.add(user);
    }

    @Override
    public void remCompartilhado(Usuario user) {
        super.compartilahdo.remove(user);
    }

    @Override
    public void remAllCompartilhado() {
        super.compartilahdo = new LinkedList<>();
    }
    
    
    
}
