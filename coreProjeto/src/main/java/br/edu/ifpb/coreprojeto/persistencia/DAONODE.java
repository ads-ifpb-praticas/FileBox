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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author laerton
 */
public class DAONODE implements IDAO<AbsNode>{

    private EntityManager em = FactoryEntetyManagerProjeto.getInstance().getEMF().createEntityManager();
    
    @Override
    public AbsNode salvar(AbsNode node) {
        try {
            em.getTransaction().begin();
            if (node.getId() != 0){
                em.remove(node.getId());
            }else{
                em.persist(node);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return node;
    }

    @Override
    public void excluir(AbsNode node) {
        try {
            em.getTransaction().begin();
            em.remove(node.getId());
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public AbsNode buscar(int id) {
        //return em.find(AbsNode.class, id);
        TypedQuery<AbsNode> query = em.createQuery("Select u from AbsNode u where u.id = :id ", AbsNode.class);
        query.setParameter("id",id );
        return query.getSingleResult();
    }

    
    
}
