package br.edu.ifpb.teste.unitario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.exception.UsuarioException;
import br.edu.ifpb.validadores.ValidaUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.omg.CORBA.UserException;

/**
 *
 * @author laerton
 */
public class TestValidaUsuario {
    
    public TestValidaUsuario() 
    {
        
    }
    
     private Usuario user1;
     private Usuario user2;
     private Usuario user3;
     private Usuario user4;
     private Usuario user5;
     private Usuario user6;
     
     @Before
     public void  setUp(){
         user1 = new Usuario(1, "Laerton", "laerton@uol.com.br", "495798");
         user2 = new Usuario(1, "", "laertonuol.com.br", "");
         user3 = new Usuario(1, null, "laerton@uolcombr", null);
         user4 = new Usuario(1, "Laerton#$##", "", "495798");
         user4 = new Usuario(1, "Laerton#$##", null, "495798");
     }
    
    
     @Test
     public void testaValidaNomeUsuario() throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaNome(user1.getNome()));
     }
    
     @Test(expected = UsuarioException.class)
     public void testValidaNomeNull() throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaNome(user3.getNome()));
     }
}
