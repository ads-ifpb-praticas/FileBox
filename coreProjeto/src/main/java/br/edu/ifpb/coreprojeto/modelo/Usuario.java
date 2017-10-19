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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import sun.security.util.Password;


/**
 * Classe cuida dos dados de um usuario.
 * @author laerton
 */
@Entity
@TableGenerator(name = "USUARIO_SEQ", allocationSize = 1)
//@SecondaryTable(name = "health_care", pkJoinColumns = 
//  { @PrimaryKeyJoinColumn(name = "id") })
public class Usuario {
    
    @Id 
    @GeneratedValue(generator = "USUARIO_SEQ", 
            strategy = GenerationType.TABLE)
    private int id;
    @Column(length = 255, nullable = false)
    private String nome;
    @Column(length = 255, nullable = false)
    private String email;
    @Column(length = 255, nullable = false)
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    private Pasta raiz;
    public Usuario() {
        
    }
    
    
    
    public Usuario( int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

  

    
    
    public Pasta getRaiz() {
        return raiz;
    }

    public void setRaiz(Pasta arquivos) {
        arquivos.setUsuario(this);
        this.raiz = arquivos;
    }
    
    public void addArquivo(AbsNode arquivo){
        arquivo.setUsuario(this);
        this.raiz.addNode(arquivo);
    }
    
    public void remArquivo(AbsNode arquivo){
        this.raiz.remNode(arquivo);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
