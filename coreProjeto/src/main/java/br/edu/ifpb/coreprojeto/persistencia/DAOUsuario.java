/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.persistencia;

import br.edu.ifpb.coreprojeto.modelo.AbsNode;
import br.edu.ifpb.coreprojeto.modelo.Arquivo;
import br.edu.ifpb.coreprojeto.modelo.TypeNode;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author laerton
 */
public class DAOUsuario implements IDAO<Usuario>{

    private EntityManager em = FactoryEntetyManagerProjeto.getInstance().getEMF().createEntityManager();
    
    @Override
    public Usuario salvar(Usuario user) {
        try {
            em.getTransaction().begin();
            if (user.getId() != 0){
                em.merge(user);
            }else {
                em.persist(user);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return user;
    }

    @Override
    public void excluir(Usuario user) {
        
        try {
            em.getTransaction().begin();
            em.remove(user.getId());
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Usuario buscar(int id) {
        return em.find(Usuario.class, id);
    }

    public List<Arquivo> findFileTamanho(int tamanho, Usuario user){
        TypedQuery<Arquivo> query = em.createQuery("Select c from Arquivo c Where c.tamanho <= :tamanho and c.Usuario = :usuario", Arquivo.class);
        query.setParameter("tamanho",tamanho);
        query.setParameter("usuario", user);
        return query.getResultList();
    }
    
    public List<AbsNode> findNodeByType(TypeNode type, Usuario user){
        TypedQuery<AbsNode> query = em.createQuery("Select c from AbsNode c Where c.type = :tipo and c.Usuario = :usuario", AbsNode.class);
        query.setParameter("tipo",type);
        query.setParameter("usuario", user);
        return query.getResultList();
     
    }
    
    public List<AbsNode> findyNodeByName(String name, Usuario user){
        TypedQuery<AbsNode> query = em.createQuery("Select c from AbsNode c Where c.nome LIKE :nome and c.Usuario = :usuario", AbsNode.class);
        query.setParameter("nome",name + "%");
        query.setParameter("usuario", user);
        return query.getResultList();
     
    }
    
    public List<AbsNode> findNodesCompartilhadosByUser(Usuario user){
        TypedQuery<AbsNode> query = em.createQuery("Select c from AbsNode c Where c.users = :user ", AbsNode.class);
        query.setParameter("user",user );
        return query.getResultList();
    }
    /*
    public List<AbsNode> findNodeCompartilhadoByUser(Usuario user){
        TypedQuery<AbsNode> query = em.createQuery("Select c from AbsNode c Where c.users", AbsNode.class);
        query.setParameter("nome",name + "%");
        query.setParameter("usuario", user);
        return query.getResultList();
    }*/

    public Usuario buscar(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
