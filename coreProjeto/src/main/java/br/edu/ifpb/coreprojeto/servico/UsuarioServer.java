/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.servico;

import br.edu.ifpb.coreprojeto.modelo.AbsNode;
import br.edu.ifpb.coreprojeto.modelo.Arquivo;
import br.edu.ifpb.coreprojeto.modelo.FactoryUsuario;
import br.edu.ifpb.coreprojeto.modelo.Pasta;
import br.edu.ifpb.coreprojeto.modelo.TypeNode;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.coreprojeto.persistencia.DAONODE;
import br.edu.ifpb.coreprojeto.persistencia.DAOUsuario;
import br.edu.ifpb.validadores.ValidaUsuario;
import java.util.List;


/**
 *
 * @author laerton
 */
public class UsuarioServer 
{
    private Usuario user ;
    private DAOUsuario dao;
    private DAONODE daoNode;
    
    public UsuarioServer(String nome, String email, String senha){
        user = FactoryUsuario.factoryUsuario(nome, email, senha);
        dao = new DAOUsuario();
        daoNode = new DAONODE();
    }

    public UsuarioServer(Usuario user) {
        
        this.user = user;
        dao = new DAOUsuario();
        daoNode = new DAONODE();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public void addPasta(Pasta pasta) throws Exception{
        String raiz = this.user.getRaiz().getEndereco() + pasta.getNome();
        FileManeger.mkdirExecute(raiz);
        user.addArquivo(pasta);
        salvar();
    }
    
    public void salvar(){
        this.dao.salvar(user);
    }
    
    public void atualizar(){
        this.user = dao.buscar(user.getId());
    }
    
    public void addArquivo(Arquivo arquivo, String enderecorigem) throws Exception{
        addArquivo(arquivo ,enderecorigem, this.user.getRaiz());
    }

    public void addArquivo(Arquivo arquivo, String enderecorigem, Pasta destino) throws Exception {
        FileManeger.copyExecute(enderecorigem, destino.getEndereco());
        destino.addNode(arquivo);
        user.addArquivo(destino);
        salvar();
    }
    
    public void remArquivo(Arquivo arquivo){
        FileManeger.delExecute(arquivo.getEndereco() + arquivo.getNome());
        daoNode.excluir(arquivo);
        atualizar();
    }
    
    public void compartilharNode (AbsNode node, Usuario user) throws Exception{
        node.addCompartilhado(user);
        daoNode.salvar(node);
        atualizar();
    }
    
    public List<AbsNode> compatilhadoComUser(){
        return dao.findNodesCompartilhadosByUser(user);
    }
   
    public List<Arquivo> buscaArquivosPorTamanho(int tamanho){
        return dao.findFileTamanho(tamanho, user);
    }
    
    public List<AbsNode> buscaNodePorNome(String nome){
        return dao.findyNodeByName(nome, user);
    }
    
    public Usuario buscaUsuarioPorNome(String nome){
        return dao.buscar(nome);
    }
    
    public List<AbsNode> buscarNodePorTipo (TypeNode type){
        return dao.findNodeByType(type, user);
    }
    
    
    
}
