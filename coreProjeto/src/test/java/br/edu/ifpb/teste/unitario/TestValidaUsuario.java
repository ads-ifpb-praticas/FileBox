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
    
     private Usuario user1 = new Usuario();
     private Usuario user2 = new Usuario();
     private Usuario user3 = new Usuario();
     private Usuario user4 = new Usuario();
     private Usuario user5 = new Usuario();
     
     
     @Before
     public void  setUp(){
         user1 = new Usuario(1, "Laerton", "laerton@uol.com.br", "495798");
         user2 = new Usuario(1, "", "laertonuol.com.br", "");
         user3 = new Usuario(1, null, "laerton@uolcombr", null);
         user4 = new Usuario(1, "Laerton#$##", "", "495798");
         user5 = new Usuario(1, "Laerton#$##", null, "495798");
     }
    
    
     @Test
     public void testaValidaNomeUsuario() throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaNome(user1.getNome()));
     }
    
     @Test(expected = UsuarioException.class)
     public void testValidaNomeNull() throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaNome(user3.getNome()));
     }
     
     @Test(expected = UsuarioException.class)
     public void testValidaNomeEmBranco() throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaNome(user2.getNome()));
     }
     
     @Test(expected = UsuarioException.class)
     public void testValidaNomeCaracteres() throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaNome(user4.getNome()));
     }
     
     @Test
     public void testValidaEmail()throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaEmail(user1.getEmail()));
     }
     
     @Test(expected = UsuarioException.class)
     public void testValidaEmailNull()throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaEmail(user5.getEmail()));
     }
     
     @Test(expected = UsuarioException.class)
     public void testValidaEmailIncompleto()throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaEmail(user2.getEmail()));
     }
     
     @Test(expected = UsuarioException.class)
     public void testValidaEmailVazio()throws UsuarioException{
         assertTrue(ValidaUsuario.ValidaEmail(user4.getEmail()));
     }
     
     @Test
     public void testValidaSenha()throws UsuarioException{
         assertTrue(ValidaUsuario.validaSenha(user1.getSenha()));
     }
     
     @Test(expected = UsuarioException.class)
     public void testValidaSenhaNull()throws UsuarioException{
         assertTrue(ValidaUsuario.validaSenha(user3.getSenha()));
     }
     
     @Test(expected = UsuarioException.class)
     public void testValidaSenhaVazia()throws UsuarioException{
         assertTrue(ValidaUsuario.validaSenha(user2.getSenha()));
     }
}