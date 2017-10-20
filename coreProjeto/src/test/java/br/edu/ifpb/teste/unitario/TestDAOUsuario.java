/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.teste.unitario;

import br.edu.ifpb.coreprojeto.modelo.AbsNode;
import br.edu.ifpb.coreprojeto.modelo.Arquivo;
import br.edu.ifpb.coreprojeto.modelo.Pasta;
import br.edu.ifpb.coreprojeto.modelo.TypeNode;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.coreprojeto.persistencia.DAOUsuario;
import java.util.List;
import javax.persistence.NoResultException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laerton
 */
public class TestDAOUsuario {
    
    
    public TestDAOUsuario() {
    }
    
    private  DAOUsuario dao = null;
    private  Usuario user ;
    
    @Before
    public void setUpClass() {
        
        dao = new DAOUsuario();
        user = new Usuario(1, "Laerton Marques de Figueiredo", "laerton281003@hotmail.com", "495798");
        Pasta raiz = new Pasta();
        raiz.setNome(String.valueOf(user.getId()));
        raiz.setEndereco(raiz.getNome());
        user.setRaiz(raiz);
        
        for (int i = 0; i < 5; i++) {
            Arquivo arq = new Arquivo();
            arq.setNome("teste"+ i + ".txt");
            arq.setTamanho(1000* (i+1));
            user.addArquivo(arq);
        }
        
    }
    
    
    @Test
    public void testSavar() {
        Usuario u = dao.salvar(user);
        assertNotNull(u);
        u.setEmail("laertonmarques@uol.com.br");
        Usuario u1 = dao.salvar(u);
        assertEquals("laertonmarques@uol.com.br",u1.getEmail());
        
    }
    
    @Test
    public void testBuscaUsuario(){
        Usuario u = dao.buscarByNome("Laerton Marques de Figueiredo");
        assertEquals("Laerton Marques de Figueiredo", u.getNome());
    }
    
    
    @Test
    public void testFindFileTamanhoMax(){
        assertTrue( dao.findFileTamanhoMax(2000, user).size()>0);
    }
    
    @Test
    public void testFindFileTamanhoMin(){
        assertTrue( dao.findFileTamanhoMin(2000, user).size()>0);
    }
    
    @Test
    public void testExcluir(){
        Usuario u = dao.buscar(1);
        dao.excluir(u);
    }
    
    @Test
    public void testfindebyType(){
        List<AbsNode> lista = dao.findNodeByType(TypeNode.ARQUIVO, user);
        for (AbsNode absNode : lista) {
            assertEquals(TypeNode.ARQUIVO, absNode.getTypeNode());
        }
        
        List<AbsNode> lista2 = dao.findNodeByType(TypeNode.DIRETORIO, user);
        for (AbsNode absNode : lista2) {
            assertEquals(TypeNode.DIRETORIO, absNode.getTypeNode());
        }
    }
    
    @Test
    public void testFindeNodeByName(){
        List<AbsNode> lista = dao.findyNodeByName("teste",user);
        assertTrue(lista.size() >0);
    }
    
    @Test 
    public void testbuscarByEmail(){
        Usuario u1 = dao.buscarByEmail("laertonmarques@uol.com.br");
        assertNotNull(u1);
    }
    
    @Test(expected = NoResultException.class) 
    public void testbuscarByEmailnaocadastrado(){
        Usuario u2 = dao.buscarByEmail("laerton@hotmail.com");
        assertNull(u2);
    }
    
    @Test
    public void testfindNodesCompartilhadosByUser(){
        List<AbsNode> lista = dao.findNodesCompartilhadosByUser(user);
        assertNotNull(lista);
    }
}

