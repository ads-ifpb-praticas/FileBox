/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.persistencia;

import br.edu.ifpb.coreprojeto.modelo.Arquivo;

/**
 *
 * @author laerton
 */
public class DAOArquivo implements IDAO<Arquivo>{

    @Override
    public Arquivo salvar(Arquivo o) {
        String SQL = "";
        if (o.getId() == 0){
            SQL = "";
        }else{
            SQL = "";
        }
        return persiste(SQL, o);
    }

    @Override
    public void excluir(Arquivo o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Arquivo buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Arquivo persiste(String SQL, Arquivo o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
