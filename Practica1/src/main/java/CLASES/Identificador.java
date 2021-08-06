/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import GUI.TablaResultados;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class Identificador {

    public void evaluarTexto(String textoNormal) {
        ArrayList<String> textoSeparado = separar(textoNormal);
        verificar(textoSeparado);
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

    private void verificar(ArrayList<String> textoSeparado) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < textoSeparado.size(); i++) {
            temp.add(identificar(textoSeparado.get(i)));
        }

        imprimir(temp);
    }

    private String identificar(String texto) {
        if (identificarID(texto)) {
            return "ID: " + texto;
        } else if (identficarNumeroEntero(texto)) {
            return "Número: " + texto;
        } else if (identificarSimbolo(texto)) {
            return "Símbolo: " + texto;
        } else if (identificarNumeroDecimal(texto)) {
            return "Decimal: " + texto;
        } else {
            return "ERROR: " + texto;
        }
    }

    private boolean identificarID(String texto) {

        if (evaluarCHAR(texto.charAt(0), CONSTANTES.ALFABETO)) {
            for (int i = 1; i < texto.length(); i++) {
                if (evaluarCHAR(texto.charAt(i), CONSTANTES.SIMBOLOS) || String.valueOf(texto.charAt(i)) == CONSTANTES.PUNTO) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean identficarNumeroEntero(String texto) {

        for (int i = 0; i < texto.length(); i++) {
            if (!evaluarCHAR(texto.charAt(i), CONSTANTES.NUMEROS)) {
                return false;
            }
        }
        return true;
    }

    private boolean identificarSimbolo(String texto) {

        for (int i = 0; i < texto.length(); i++) {
            if (!evaluarCHAR(texto.charAt(i), CONSTANTES.SIMBOLOS)) {
                return false;
            }
        }
        return true;
    }

    private boolean identificarNumeroDecimal(String texto) {
        int contadorPunto = 0;
        if (evaluarCHAR(texto.charAt(0), CONSTANTES.NUMEROS)) {
            for (int i = 1; i < texto.length(); i++) {
                if (!String.valueOf(texto.charAt(i)).equalsIgnoreCase(CONSTANTES.PUNTO)) {
                    if (!evaluarCHAR(texto.charAt(i), CONSTANTES.NUMEROS)) {
                        return false;
                    }
                } else if (contadorPunto == 0) {
                    contadorPunto++;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;

    }

    private boolean evaluarCHAR(char charEvaluado, String[] datos) {
        for (int i = 0; i < datos.length; i++) {
            if (String.valueOf(charEvaluado).equalsIgnoreCase(datos[i])) {
                return true;
            }
        }
        return false;
    }

    private void imprimir(ArrayList<String> imprimir) {
        TablaResultados tabla = new TablaResultados();
        DefaultTableModel modelo = new DefaultTableModel();

        tabla.getTabla().setModel(modelo);
        modelo.addColumn("TEXTO RESULTADO");
        for (int i = 0; i < imprimir.size(); i++) {
            modelo.addRow(new Object[]{imprimir.get(i)});
        }
        
        tabla.setVisible(true);
    }
}
