/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.filebox.controle;


import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.coreprojeto.servico.IUsuarioServer;
import br.edu.ifpb.exception.UsuarioException;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */

@Named
@SessionScoped
public class UsuarioControle implements Serializable{
    
    @Inject
    private IUsuarioServer server;
    @Inject
    private Usuario user;
    public UsuarioControle() 
    {
        
    }
    
    public void logar(String email, String senha) throws UsuarioException
    {
        server.logarUser(email, senha);
        user= server.getUser();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
