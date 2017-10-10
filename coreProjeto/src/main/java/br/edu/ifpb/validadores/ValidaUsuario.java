package br.edu.ifpb.validadores;


import br.edu.ifpb.exception.UsuarioException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laerton
 */
public class ValidaUsuario {
    /***
     * Valida nome do usuario
     * @param nome - nome o usuario.
     * @return - Booleano
     * @throws UsuarioException Nao aceita branco, nulo ou caracteres especiais.
     */
    public static boolean ValidaNome(String nome) throws UsuarioException{
        
        if (nome ==null){
            throw  new UsuarioException("Usuario nao pode ser nulo.");
        }
        
        if (nome.trim().equals("")){
            throw  new UsuarioException("Nome de usuario nao pode ser em branco.");
        }
        
        Pattern p = Pattern.compile("^[a-zA-Z0-9!#? \\p{L}]+$");
        Matcher m = p.matcher(nome);
        if(!m.matches())
            throw new UsuarioException("O nome do usuario nao pode conter #,! or ? ou caracteres especiais!");
        
        return true;
    }
    /***
     * Valida email do usuario
     * @param email - Email a ser validado
     * @return Booleano
     * @throws UsuarioException Nao aceita em branco, nulo e deve conter @ e .
     */
    public static boolean ValidaEmail(String email) throws UsuarioException{
        if (email.equals(null)){
            throw  new UsuarioException("Email nao pode ser nulo.");
        }
  
        if (email.trim().equals("")){
            throw  new UsuarioException("Email de usuario nao pode ser em branco.");
        }
        
        if (!(email.contains("@") && email.contains("."))){
            throw  new UsuarioException("Email invalido.");
        }
        return true;
    }
    /***
     * Valida a senha do usuario
     * @param senha - Senha a ser validada
     * @return Boleano
     * @throws UsuarioException Nao aceita senhas nulas ou em branco.
     */
    public static boolean validaSenha(String senha) throws UsuarioException{
        if (senha.equals(null)){
            throw  new UsuarioException("Senha nao pode ser nulo.");
        }
        if (senha.trim().equals("")){
            throw  new UsuarioException("Senha de usuario nao pode ser em branco.");
        }
        
        return true;
    }
    
}
