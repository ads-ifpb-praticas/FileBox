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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author laerton
 */

@Entity
public abstract class AbsNode {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @ManyToOne @JoinColumn(name = "id_user")
    protected Usuario  Usuario;
    @ManyToOne @JoinColumn(name = "id_node")
    @Column(nullable = true)
    protected AbsNode node = null;
    @Column(length = 255, nullable = false)
    protected String endereco;
    @Column(length = 255, nullable = false)
    protected String nome;
    @OneToMany()
    protected List<Usuario> compartilahdo  = new LinkedList<>();
    protected Integer tamanho;
    @Enumerated(EnumType.ORDINAL)
    protected TypeNode type;

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public AbsNode getNode() {
        return node;
    }

    public void setNode(AbsNode node) {
        this.node = node;
    }

    public List<Usuario> getCompartilahdo() {
        return compartilahdo;
    }

    public void setCompartilahdo(List<Usuario> compartilahdo) {
        this.compartilahdo = compartilahdo;
    }

    

    public TypeNode getType() {
        return type;
    }

    public void setType(TypeNode type) {
        this.type = type;
    }

    
    
    public String getNome() {
        return this.nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public TypeNode getTypeNode() {
        return this.type;
    }

    
    public int getId() {
        return this.id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    

    
    public String getEndereco() {
        return this.endereco;
    }

    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public abstract void setTamanho(Integer tamanho);
    public abstract Integer getTamanho() ;

    
    public abstract List<Usuario> getCompartilhado();

    
    public abstract void setCompartilhado(List<Usuario> usuarios);

    
    public abstract void addCompartilhado(Usuario user);

    
    public abstract void remCompartilhado(Usuario user);

    
    public abstract void remAllCompartilhado();

}
