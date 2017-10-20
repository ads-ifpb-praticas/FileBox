/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.coreprojeto.servico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;


/**
 *
 * @author laerton
 */
public class FileManeger {
    /**
	 * Cria um diretorio, cujo nome e' especificado pelo parametro <i>path</i>.
	 * @param path Caminho do diretorio a ser criado
	 */
	public static boolean mkdirExecute(String path) throws Exception{
		File file = new File(path);
		return file.mkdir();
	}
        
        
        
        
        /**
	 * Remove o arquivo especificado pelo parametro <i>filename</i>.
	 * @param filenamePath Nome do arquivo a ser removido com diretorio
	 */
	public static boolean delExecute(String filenamePath) {
		
		File file = new File(filenamePath);
                return file.delete(); 
			
	}
        
        /**
	 * Copia um arquivo origem para um arquivo destino.
	 * @param origem Caminho completo do arquivo origem
	 * @param destino Caminho completo do arquivo destino
	 */
	public static boolean copyExecute(String origem, String destino)  throws Exception{
	        File fIn = new File (origem);
                File fOut = new File (destino);
                FileInputStream fis = new FileInputStream (fIn);
                FileOutputStream fos = new FileOutputStream (fOut);
                FileChannel fcIn = fis.getChannel();
                FileChannel fcOut = fos.getChannel();
                fcOut.transferFrom (fcIn, 0, fIn.length());
                fos.close();
                fis.close();
                return true;
	}
        
        public static long sizeFile(String origem){
            return new File (origem).length();
        }
        
        
        
        
}
