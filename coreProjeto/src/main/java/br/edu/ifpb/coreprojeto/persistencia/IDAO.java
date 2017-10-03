/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.persistencia;

/**
 *
 * @author laerton
 */
public interface IDAO <T> {
    T salvar(T o);
    void excluir(T o);
    T buscar(int id);
}
