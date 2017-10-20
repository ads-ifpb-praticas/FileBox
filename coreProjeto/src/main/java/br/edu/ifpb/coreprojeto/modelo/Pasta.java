/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import br.edu.ifpb.coreprojeto.anotacao.CoberturaIgnore;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Classe relacionanda a uma pasta dpe arquivos.
 * @author laerton
 */
@Entity
public class Pasta extends AbsNode {
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<AbsNode> conteudo = new LinkedList<>();

    public Pasta() {
        super.type = TypeNode.DIRETORIO;
    }
    
    
    @Override
    @Transient
    @CoberturaIgnore
    public long getTamanho() {
        long tamanho = 0;
        for (AbsNode absNode : conteudo) {
            tamanho += absNode.getTamanho();
        }
        return tamanho;
    }

    
    @Override
    @CoberturaIgnore
    public List<Usuario> getCompartilhado() {
        List<Usuario> usuarios =new LinkedList<>();
        for (AbsNode absNode : conteudo) {
            usuarios.addAll(absNode.getCompartilhado());
        }
        return usuarios;
    }

    @Override
    public void setCompartilhado(List<Usuario> usuarios) {
        this.users = usuarios;
    }

    @Override
    @CoberturaIgnore
    public void addCompartilhado(Usuario user) throws Exception {
        super.addCompartilhado(user);
        
        for (AbsNode absNode : conteudo)
        {
            absNode.addCompartilhado(user);
        }
        this.users.add(user);
        
    }

    @Override
    public void remCompartilhado(Usuario user) {
        for (AbsNode absNode : conteudo) {
            absNode.remCompartilhado(user);
        }
        this.users.remove(user);
    }

    @Override
    public void remAllCompartilhado() {
        for (AbsNode absNode : conteudo) {
            absNode.remAllCompartilhado();
        }
    }

    public List<AbsNode> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<AbsNode> conteudo) {
        this.conteudo = conteudo;
    }
    
    public void addNode(AbsNode node){
        node.setParent(this);
        node.setUsuario(this.Usuario);
        node.setEndereco(this.endereco +"//" + node.getEndereco());
        conteudo.add(node);
    }
   
    public void remNode(AbsNode node){
        conteudo.remove(node);
    }
    
    
}
