/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;


import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author laerton
 */

@Entity
@Inheritance ( strategy = InheritanceType.SINGLE_TABLE )
@Table(name = "Node")
@TableGenerator(name = "NODE_SEQ", allocationSize = 1)

public abstract class AbsNode {
    @Id @GeneratedValue( generator = "NODE_SEQ" , strategy = GenerationType.TABLE)
    protected int id;
    
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "id_user", nullable = false)
    protected Usuario  Usuario;
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "id_node", nullable = true)
    protected AbsNode parent = null;
    @Column(length = 255, nullable = false)
    protected String endereco = "";
    @Column(length = 255, nullable = false)
    protected String nome;
    
    @ManyToMany()
    protected List<Usuario> users  = new LinkedList<>();
    protected long tamanho;
    @Enumerated(EnumType.ORDINAL)
    protected TypeNode type;

    public Usuario getUsuario() {
        return Usuario;
    }

    public long getTamanho() {
        return tamanho;
    }

    
    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public AbsNode getParent() {
        return parent;
    }

    public void setParent(AbsNode node) {
        this.parent = node;
    }

    public List<Usuario> getCompartilhado() {
        return users;
    }

    public void setCompartilahdo(List<Usuario> compartilahdo) {
        this.users = compartilahdo;
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

    
    public String getEndereco(){
        return this.endereco;
    }

    
    public void setEndereco(String endereco) {
            this.endereco =  endereco;
    }
    
    
    public abstract void setCompartilhado(List<Usuario> usuarios);

    
    public void addCompartilhado(Usuario user) throws Exception{
        if (this.Usuario != null && this.Usuario.equals(user)){ 
            throw  new Exception("Nao pode compartilha o objeto para o dono do mesmo.");
        }
        user.addArquivo(this);
    }

    
    public abstract void remCompartilhado(Usuario user);

    
    public abstract void remAllCompartilhado();

}
