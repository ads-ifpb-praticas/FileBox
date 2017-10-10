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
public class Arquivo implements INode{
    private int id, idUser;
    private String endereco, nome;
    private List<Usuario> compartilahdo  = new LinkedList<>();
    private Integer tamanho;
    private final TypeNode type = TypeNode.ARQUIVO;

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public TypeNode getTypeNode() {
        return this.type;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getIdUser() {
        return this.idUser;
    }

    @Override
    public void setIdUser(int id) {
        this.idUser = id;
    }

    @Override
    public String getEndereco() {
        return this.endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public Integer getTamanho() {
        return this.tamanho;
    }

    @Override
    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public List<Usuario> getCompartilhado() {
        return compartilahdo;
    }

    @Override
    public void setCompartilhado(List<Usuario> lista) {
        this.compartilahdo =lista;
    }

    @Override
    public void addCompartilhado(Usuario user) {
        this.compartilahdo.add(user);
    }

    @Override
    public void remCompartilhado(Usuario user) {
        this.compartilahdo.remove(user);
    }

    @Override
    public void remAllCompartilhado() {
        this.compartilahdo.removeAll(compartilahdo);
    }

    
    
}
