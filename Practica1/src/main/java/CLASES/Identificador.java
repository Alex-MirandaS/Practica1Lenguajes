/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Alex
 */
public class Identificador {
    
    public void evaluarTexto(String textoNormal) {
        ArrayList<String> textoSeparado = separar(textoNormal);
        for (int i = 0; i < textoSeparado.size(); i++) {
            System.out.println(textoSeparado.get(i));
            System.out.println(" ");
        }
    }
    
    public ArrayList<String> separar(String textoNormal) {
        ArrayList<String> temporal = new ArrayList<>();
        String textoTemp = "";
        
        for (int i = 0; i < textoNormal.length(); i++) {
            if (textoNormal.charAt(i) != ' ') {
                textoTemp = textoTemp + textoNormal.charAt(i);
                if ((i + 1) < textoNormal.length() && textoNormal.charAt(i + 1) == ' ') {
                    temporal.add(textoTemp);
                    textoTemp = "";
                } else if ((i + 1) == textoNormal.length() && textoNormal.charAt(i) != ' ') {
                    temporal.add(textoTemp);
                }
            }
        }
        
        return temporal;
    }
    
}
