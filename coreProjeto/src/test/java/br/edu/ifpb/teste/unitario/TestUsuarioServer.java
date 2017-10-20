/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.teste.unitario;

import br.edu.ifpb.coreprojeto.modelo.AbsNode;
import br.edu.ifpb.coreprojeto.modelo.Arquivo;
import br.edu.ifpb.coreprojeto.modelo.Pasta;
import br.edu.ifpb.coreprojeto.modelo.Propriedades;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.coreprojeto.persistencia.DAONODE;
import br.edu.ifpb.coreprojeto.persistencia.DAOUsuario;
import br.edu.ifpb.coreprojeto.servico.FileManeger;
import br.edu.ifpb.coreprojeto.servico.UsuarioServer;
import br.edu.ifpb.exception.UsuarioException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author laerton
 */
public class TestUsuarioServer {
    
    public TestUsuarioServer() {
    }
    @Mock
    private DAOUsuario dao = null;
    @Mock
    private DAONODE daoNode = null;
    private UsuarioServer servico = null;
    private Usuario user2 = null;
    
    
    /*@BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }*/
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Usuario user = new Usuario(1, "Laerton Marques de Figueiredo", "laerton281003@hotmail.com", "495798");
        user2  = new Usuario(2,"Segundo usuario" , "teste@teste.com", "123456");
        
        Propriedades propriedades = new Propriedades();
        propriedades.setId(1);
        propriedades.setTamanho(1500);
        user.setPropriedades(propriedades);
        Pasta raiz = new Pasta();
        raiz.setNome(String.valueOf(user.getId()));
        raiz.setEndereco(raiz.getNome());
        raiz.setId(1);
        user.setRaiz(raiz);
        
        Pasta raiz2 = new Pasta();
        raiz2.setNome(String.valueOf(user.getId()));
        raiz2.setEndereco(raiz.getNome());
        raiz2.setId(8);
        user2.setRaiz(raiz2);
        
        Pasta particular = new Pasta();
        
        for (int i = 0; i < 10; i++) {
            Arquivo arq = new Arquivo();
            arq.setNome("teste"+i+".txt");
            arq.setTamanho(1000 * (i +1));
            arq.setId(i + 10);
            user.addArquivo(arq);
        }
        List<Arquivo> at2000 = new LinkedList<>();
        List<Arquivo> mi2000 = new LinkedList<>();
        for (AbsNode absNode : user.getRaiz().getConteudo()) {
            if (absNode.getTamanho() <= 2000) 
                at2000.add((Arquivo)absNode);
            else 
                mi2000.add((Arquivo)absNode);
        }
        when(dao.buscar(any(Integer.class))).thenReturn(user);
        when(dao.buscarByNome(any(java.lang.String.class))).thenReturn(user);
        when(dao.buscarByEmail("laerton281003@hotmail.com")).thenReturn(user);
        when(dao.findFileTamanhoMax(2000, user)).thenReturn(at2000);
        when(dao.findFileTamanhoMin(2000, user)).thenReturn(mi2000);
     
        servico = new UsuarioServer(user);
        servico.setDao(dao);
        servico.setDaoNode(daoNode);
        //Criando o ambiente para os arquivos de teste
        try {
            FileManeger.mkdirExecute(String.valueOf(raiz.getId()));
            FileWriter fw = new FileWriter("teste.txt");
        } catch (Exception ex) {
            Logger.getLogger(TestUsuarioServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /*
    @After
    public void tearDown() {
    }*/

    
     @Test
     public void testLogarUser() throws UsuarioException{
         servico.logarUser("laerton281003@hotmail.com", "495798");
     }
     
     @Test(expected = UsuarioException.class)
     public void testLogaUserEmailInvalido() throws  UsuarioException{
         servico.logarUser("laerton281003@hotmail", "495798");
     }
     
     
     @Test
     public void testAddPasta() throws Exception {
         Pasta pasta = new Pasta();
         pasta.setId(5);
         pasta.setNome("nova pasta");
         servico.addPasta(pasta);
     }

     @Test
     public void testAddArquivo() throws Exception{
         Arquivo arq = new Arquivo();
         arq.setNome("teste.txt");
         arq.setTamanho(1000);
         arq.setId(7);
         servico.addArquivo(arq, "teste.txt");
         List<AbsNode> lista = servico.getUser().getRaiz().getConteudo();
         boolean contem = false;
         for (AbsNode absNode : lista) {
             if(absNode.getNome().equals(arq.getNome())){
                 contem = true;
             }
         }
         assertTrue(contem);
     }
     
     @Test(expected = Exception.class)
     public void testAddArquivoGrande() throws Exception{
         Arquivo arq = new Arquivo();
         arq.setNome("teste.txt");
         arq.setTamanho(10000);
         arq.setId(7);
         servico.addArquivo(arq, "teste.txt");
         List<AbsNode> lista = servico.getUser().getRaiz().getConteudo();
         boolean contem = false;
         for (AbsNode absNode : lista) {
             if(absNode.getNome().equals(arq.getNome())){
                 contem = true;
             }
         }
         assertTrue(contem);
     }
     
     @Test(expected = Exception.class)
     public void testAddArquivoInexistente() throws Exception{
         Arquivo arq = new Arquivo();
         arq.setNome("teste1.txt");
         arq.setTamanho(1000);
         arq.setId(7);
         servico.addArquivo(arq, "teste1.txt");
         List<AbsNode> lista = servico.getUser().getRaiz().getConteudo();
         boolean contem = false;
         for (AbsNode absNode : lista) {
             if(absNode.getNome().equals(arq.getNome())){
                 contem = true;
             }
         }
         assertTrue(contem);
     }
     
     @Test
     public void testRemoveArquivo() throws Exception{
         Arquivo arq = new Arquivo();
         arq.setNome("teste.txt");
         arq.setTamanho(1000);
         arq.setId(7);
         servico.addArquivo(arq, "teste.txt");
         servico.remArquivo(arq);
         List<AbsNode> lista = servico.getUser().getRaiz().getConteudo();
         boolean contem = false;
         for (AbsNode absNode : lista) {
             if(absNode.equals(arq)){
                 contem = true;
             }
         }
         assertFalse(contem);
     }
     
     @Test
     public void testAdicionandoPropriedades(){
         Propriedades propriedades =new Propriedades();
         propriedades.setId(0);
         propriedades.setTamanho(1000);
         servico.setPropriedades(propriedades);
         
     }
     
     @Test
     public void testCompartilhaArquivo() throws Exception{
         List<AbsNode> lista = servico.getUser().getRaiz().getConteudo();
         Arquivo arq = (Arquivo) lista.get(0);
         servico.compartilharNode(arq, user2);
         for (AbsNode absNode : servico.getNodes().getConteudo()) {
             if(arq.equals((Arquivo)absNode)){
                 assertTrue(absNode.getCompartilhado().contains(user2));
             }
         }
     }
     
     @Test(expected = Exception.class)
     public void testCompartilhaArquivoParaMesmoUsuario() throws Exception{
         List<AbsNode> lista = servico.getUser().getRaiz().getConteudo();
         Arquivo arq = (Arquivo) lista.get(0);
         servico.compartilharNode(arq, servico.getUser());
         
     }
     
     @Test
     public void testbuscaArquivosPorTamanhoMax(){
         List<Arquivo> lista = servico.buscaArquivosPorTamanhoMax(2000);
         assertEquals(2, lista.size());
     }
     
     @Test
     public void testbuscaArquivosPorTamanhoMin(){
         List<Arquivo> lista = servico.buscaArquivosPorTamanhoMin(2000);
         assertEquals(8, lista.size());
     }
     
     
}
