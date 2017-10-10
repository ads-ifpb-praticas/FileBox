/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import java.util.List;

/**
 *
 * @author laerton
 */
public interface INode {
    
    
    String getNome();
    void setNome(String nome);
    
    TypeNode getTypeNode();
    
    int getId();
    void setId(int id);
    
    int getIdUser();
    void setIdUser(int id);
    
    String getEndereco();
    void setEndereco(String endereco);
    
    Integer getTamanho();
    void setTamanho(Integer tamanho);
    
    List<Usuario> getCompartilhado();
    void setCompartilhado(List<Usuario> lista);
    
    void addCompartilhado(Usuario user);
    void remCompartilhado(Usuario user);
    void remAllCompartilhado();
    
    
            
    
    
    
}
