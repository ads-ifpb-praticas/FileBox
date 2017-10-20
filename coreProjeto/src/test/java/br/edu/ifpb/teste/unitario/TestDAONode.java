/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.teste.unitario;

import br.edu.ifpb.coreprojeto.modelo.AbsNode;
import br.edu.ifpb.coreprojeto.modelo.Arquivo;
import br.edu.ifpb.coreprojeto.modelo.FactoryUsuario;
import br.edu.ifpb.coreprojeto.modelo.Pasta;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.coreprojeto.persistencia.DAONODE;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laerton
 */
public class TestDAONode {
    
    public TestDAONode() {
    }
    
    private Pasta pasta;
    private Arquivo arquivo;
    private DAONODE dao;
    
    @Before
    public void setUp() {
        Usuario user = new Usuario(1, "laerton", "shaksjdh@sjhdjskha", "sdhfkj");
        dao = new DAONODE();
        pasta = new Pasta();
        pasta.setId(10000);
        pasta.setNome("pasta");
        pasta.setUsuario(user);
        arquivo = new Arquivo();
        arquivo.setId(10001);
        arquivo.setTamanho(1000);
        arquivo.setNome("arq.txt");
        pasta.addNode(pasta);
    }
    

     @Test
     public void testeSalvar() 
     {
         Pasta p = (Pasta) dao.salvar(pasta);
         assertNotNull(p);
         p.setNome("nova");
         Pasta p1 = (Pasta) dao.salvar(p);
         assertEquals("nova", p1.getNome());
     }
     
     @Test
     public void testBuscar(){
         Pasta p = (Pasta) dao.buscar(1);
         assertNotNull(p);
     }
     
     @Test
     public void testExcluir(){
         Pasta p = (Pasta) dao.buscar(1);
         dao.salvar(pasta);
     }
     
     
     
    
}
