/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.persistencia;

import br.edu.ifpb.coreprojeto.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class DAOUsuario implements IDAO<Usuario>{

    @Override
    public Usuario salvar(Usuario o) {
        String sql = "";
        if (o.getId() == 0){
            sql = "insert into usuario (nome, email, senha) values (?,?,?);";
        }else{
            sql = "update usuario set (nome = ?, email =?, senha = ?) where id = ?;";
        }
        return petsiste (sql, o);
    }

    @Override
    public void excluir(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Usuario petsiste(String sql, Usuario o) {
        try {
            Conexao con = Conexao.getInstance();
            PreparedStatement ps = con.getCon().prepareStatement(sql);
            ps.setString(1, o.getNome());
            ps.setString(2, o.getEmail());
            ps.setString(3, o.getSenha());
            if (o.getId()!=0){
                ps.setInt(4, o.getId());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
    
}
