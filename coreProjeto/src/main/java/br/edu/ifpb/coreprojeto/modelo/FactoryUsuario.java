/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

import br.edu.ifpb.coreprojeto.persistencia.DAOUsuario;

/**
 *
 * @author laerton
 */
public class FactoryUsuario {
    
    public static Usuario factoryUsuario(String nome, String email, String senha)
    {
        Usuario user = new Usuario(0, nome, email, senha);
        DAOUsuario dao = new DAOUsuario();
        user = dao.salvar(user);
        Pasta raiz = new Pasta();
        raiz.setNome(String.valueOf(user.getId()));
        raiz.setEndereco("\\" + raiz.getNome());
        user.setRaiz(raiz);
        user = dao.salvar(user);
        
        return user;
        
    }
}
