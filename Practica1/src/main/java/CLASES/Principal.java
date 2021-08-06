/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import GUI.PrincipalGUI;

/**
 *
 * @author Alex
 */
public class Principal {

    private PrincipalGUI principal;
    private Identificador identificador;

    public Principal() {

        identificador = new Identificador();
        principal = new PrincipalGUI(identificador);

    }

    public void iniciar() {
        principal.setVisible(true);
    }
}
