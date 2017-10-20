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

/**
 *
 * @author laerton
 */
public interface IUsuarioServer {

    void addArquivo(Arquivo arquivo, String enderecorigem) throws Exception;

    void addArquivo(Arquivo arquivo, String enderecorigem, Pasta destino) throws Exception;

    void addPasta(Pasta pasta) throws Exception;

    void atualizar();

    List<Arquivo> buscaArquivosPorTamanhoMax(int tamanho);

    List<Arquivo> buscaArquivosPorTamanhoMin(int tamanho);

    List<AbsNode> buscaNodePorNome(String nome);

    Usuario buscaUsuarioPorNome(String nome);

    List<AbsNode> buscarNodePorTipo(TypeNode type);

    void compartilharNode(AbsNode node, Usuario user) throws Exception;

    List<AbsNode> compatilhadoComUser();

    DAOUsuario getDao();

    DAONODE getDaoNode();

    Pasta getNodes();

    @CoberturaIgnore
    Propriedades getPropriedades();

    Usuario getUser();

    void logarUser(String email, String senha) throws UsuarioException;

    void remArquivo(Arquivo arquivo);

    void salvar();

    void setDao(DAOUsuario dao);

    void setDaoNode(DAONODE daoNode);

    void setPropriedades(Propriedades propriedades);

    void setUser(Usuario user);
    
}
