/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import br.edu.ifpb.coreprojeto.anotacao.CoberturaIgnore;
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
@Entity
public class Arquivo extends AbsNode{
    
    
    
    public Arquivo() 
    {
        super.type = TypeNode.ARQUIVO;
        this.endereco = "";
    }

    
    public void setTamanho(long tamanho) {
        super.tamanho =tamanho;
    }

    @Override
    public long getTamanho() {
        return super.tamanho;
    }

    @Override
    public List<Usuario> getCompartilhado() {
        return super.users;
    }
    @CoberturaIgnore
    @Override
    public void setCompartilhado(List<Usuario> usuarios) {
        super.users=usuarios;
    }

    @Override
    public void addCompartilhado(Usuario user) throws Exception {
        super.addCompartilhado(user);
        this.users.add(user);
    }

    @CoberturaIgnore
    @Override
    public void remCompartilhado(Usuario user) {
        this.users.remove(user);
    }

    @CoberturaIgnore
    @Override
    public void remAllCompartilhado() {
        this.users = new LinkedList<>();
    }

    
    
    
    
    
}
