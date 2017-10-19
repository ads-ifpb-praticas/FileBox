
import br.edu.ifpb.coreprojeto.modelo.AbsNode;
import br.edu.ifpb.coreprojeto.modelo.FactoryUsuario;
import br.edu.ifpb.coreprojeto.modelo.Pasta;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import br.edu.ifpb.coreprojeto.persistencia.DAOUsuario;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.Icon;
import br.edu.ifpb.coreprojeto.modelo.*;
import br.edu.ifpb.coreprojeto.persistencia.DAONODE;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laerton
 */
public class app {
 
    public static void main(String[] args) throws Exception {
        
        DAOUsuario dao = new DAOUsuario();
        DAONODE daoNode = new DAONODE();
        Usuario user = FactoryUsuario.factoryUsuario("Laerton Marques", "laerton240311@gmail.com", "sil495798");
        Usuario user1 = FactoryUsuario.factoryUsuario("Laerton2", "laertn281003@hotmail.com", "495798");
        
        Pasta pasta = new Pasta();
        pasta.setNome("ArquivosPessoais");
        pasta.setUsuario(user);
        Arquivo arq = new Arquivo();
        arq.setNome("teste.txt");
        arq.setTamanho(1000);
        arq.addCompartilhado(user1);
        pasta.addNode(arq);
        user.addArquivo(pasta);
        dao.salvar(user);

        List<AbsNode> compartilhado = dao.findNodesCompartilhadosByUser(user1);
        for (AbsNode absNode : compartilhado) {
            System.out.println(absNode.getNome());
        }
        
    }
    
    private static void laco (Collection<AbsNode> colecao){
        for (AbsNode absNode : colecao) {
            if (absNode.getType() == TypeNode.DIRETORIO){
                System.out.println("Conteudo do sub diretorio:" + absNode.getNome());
                laco(((Pasta)absNode).getConteudo());
            }else{
                System.out.println("Arquivo: " + absNode.getEndereco()  + absNode.getNome());
            }
        }
    }
    
}
