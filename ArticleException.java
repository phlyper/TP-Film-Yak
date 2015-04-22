/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpyak;

/**
 *
 * @author Atef
 */
public class ArticleException extends Exception {

	public ArticleException(String message) {
		super(message);
	}
	@Override
	public void finalize() throws Throwable {
		super.finalize();
		System.out.println(this.getClass().getName()+" Objet nettoyé de la mémoire");
	}
}
