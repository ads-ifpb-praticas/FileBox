/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.servico;

import br.edu.ifpb.coreprojeto.anotacao.CoberturaIgnore;
import br.edu.ifpb.coreprojeto.modelo.AbsNode;
import br.edu.ifpb.coreprojeto.modelo.Arquivo;

import br.edu.ifpb.coreprojeto.modelo.Pasta;
import br.edu.ifpb.coreprojeto.modelo.Propriedades;
import br.edu.ifpb.coreprojeto.modelo.TypeNode;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.coreprojeto.persistencia.DAONODE;
import br.edu.ifpb.coreprojeto.persistencia.DAOUsuario;
import br.edu.ifpb.exception.UsuarioException;
import java.util.List;
import javax.persistence.metamodel.StaticMetamodel;



/**
 *
 * @author laerton
 */

public class UsuarioServer implements IUsuarioServer 
{
    private Usuario user ;
    private DAOUsuario dao;
    private DAONODE daoNode;
    

    @Override
    public void logarUser(String email, String senha) throws UsuarioException 
    {
        Usuario usuario = dao.buscarByEmail(email);
        if (usuario == null || !usuario.getSenha().equals(senha))
        {
            throw new  UsuarioException("E-mail ou senha do usuario invalido.");
        }
        this.user = usuario;
    }
    
    public UsuarioServer(Usuario user) {
        
        this.user = user;
        dao = new DAOUsuario();
        daoNode = new DAONODE();
    }

    @Override
    public DAOUsuario getDao() {
        return dao;
    }

    @Override
    public void setDao(DAOUsuario dao) {
        this.dao = dao;
    }

    @Override
    public DAONODE getDaoNode() {
        return daoNode;
    }

    @Override
    public void setDaoNode(DAONODE daoNode) {
        this.daoNode = daoNode;
    }

    
    
    @Override
    public Usuario getUser() {
        return user;
    }

    @Override
    public void setUser(Usuario user) {
        this.user = user;
    }
  
    @CoberturaIgnore
    @Override
    public Propriedades getPropriedades(){
        return this.user.getPropriedades();
    }
    
    @Override
    public void setPropriedades(Propriedades propriedades){
        this.user.setPropriedades(propriedades);
        salvar();
    }
    
    @Override
    public void addPasta(Pasta pasta) throws Exception{
        String raiz = this.user.getRaiz().getEndereco() + "//" + pasta.getNome();
        
        FileManeger.mkdirExecute(raiz);
        user.addArquivo(pasta);
        salvar();
    }
    
    @Override
    public void salvar(){
        this.dao.salvar(user);
    }
    
    @Override
    public void atualizar(){
        this.user = dao.buscar(user.getId());
    }
    
    @Override
    public Pasta getNodes(){
        return user.getRaiz();
    }
    @Override
    public void addArquivo(Arquivo arquivo, String enderecorigem) throws Exception{
        addArquivo(arquivo ,enderecorigem, this.user.getRaiz());
    }

    @Override
    public void addArquivo(Arquivo arquivo, String enderecorigem, Pasta destino) throws Exception {
        if (arquivo.getTamanho() > user.getPropriedades().getTamanho()){
            throw  new Exception("Arquivo acima do tamanho limite.");
        }
        arquivo.setTamanho(FileManeger.sizeFile(destino.getEndereco()+ "//" + arquivo.getNome()));
        FileManeger.copyExecute(enderecorigem, destino.getEndereco()+ "//" + arquivo.getNome());
        destino.addNode(arquivo);
        user.addArquivo(destino);
        salvar();
    }
    
    @Override
    public void remArquivo(Arquivo arquivo){
        FileManeger.delExecute(arquivo.getEndereco() + arquivo.getNome());
        user.remArquivo(arquivo);
        daoNode.excluir(arquivo);
        atualizar();
    }
    
    @Override
    public void compartilharNode (AbsNode node, Usuario user) throws Exception{
        node.addCompartilhado(user);
        daoNode.salvar(node);
        atualizar();
    }
    
    @Override
    public List<AbsNode> compatilhadoComUser(){
        return dao.findNodesCompartilhadosByUser(user);
    }
   
    @Override
    public List<Arquivo> buscaArquivosPorTamanhoMax(int tamanho){
        return dao.findFileTamanhoMax(tamanho, user);
    }
    
    @Override
    public List<Arquivo> buscaArquivosPorTamanhoMin(int tamanho){
        return dao.findFileTamanhoMin(tamanho, user);
    }
    
    @Override
    public List<AbsNode> buscaNodePorNome(String nome){
        return dao.findyNodeByName(nome, user);
    }
    
    @Override
    public Usuario buscaUsuarioPorNome(String nome){
        return dao.buscarByNome(nome);
    }
    
    @Override
    public List<AbsNode> buscarNodePorTipo (TypeNode type){
        return dao.findNodeByType(type, user);
    }
    
    
    
}
