/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Conexao {
    private static Conexao _instance ;
    private Connection _con;
    
    private Conexao() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        this._con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "root", "sil495798");
    }
    
    public static Conexao getInstance () throws ClassNotFoundException, SQLException{
        if (_instance == null){
            _instance = new Conexao();
        }
        return _instance;
    }   

    public Connection getCon() {
        return _con;
    }
    
    public void closeCon() throws SQLException{
        this._con.close();
        _instance = null;
    }
    
    
}
