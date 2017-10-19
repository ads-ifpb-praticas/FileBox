/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.persistencia;

import br.edu.ifpb.coreprojeto.modelo.Propriedades;
import br.edu.ifpb.coreprojeto.modelo.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author laerton
 */
public class DAOPropriedades implements IDAO<Propriedades>
{
    private EntityManager em = FactoryEntetyManagerProjeto.getInstance().getEMF().createEntityManager();
    @Override
    public Propriedades salvar(Propriedades prop) {
        try {
            em.getTransaction().begin();
            if (prop.getId() != 0){
                em.merge(prop);
            }else {
                em.persist(prop);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return prop;
    }

    @Override
    public void excluir(Propriedades prop) {
        try {
            em.getTransaction().begin();
            em.remove(prop.getId());
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Propriedades buscar(int id) {
        return em.find(Propriedades.class, id);
    }
    
    
}
