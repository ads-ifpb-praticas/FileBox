/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.modelo;

/**
 *
 * @author laerton
 */
enum TypeNode {
    
    DIRETORIO (0), ARQUIVO (1);
    private int value;

    private TypeNode(int value) {
        this.value = value;
    }

}
