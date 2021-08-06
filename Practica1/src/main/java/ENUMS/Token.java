/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENUMS;

/**
 *
 * @author Alex
 */
public enum Token {

    ID("Identificador"),
    ENTERO("Entero"),
    DECIMAL("Decimal"),
    SIMBOLO("Símbolo"),
    CARACTER("Símbolo");

    private String nombre;

    private Token(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
