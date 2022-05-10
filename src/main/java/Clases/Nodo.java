/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author goku3
 */
public class Nodo {
    //Atributos
    private int coe, exp;
    private  Nodo liga;
    
    //Metodos
    public Nodo(int coe, int exp)
    {
        this.coe = coe;
        this.exp = exp;
        liga = null;
    }
    public Nodo()
    {
        coe = 0;
        exp = 0;
        liga = null;
    }

    public int getCoe() {
        return coe;
    }

    public void setCoe(int coe) {
        this.coe = coe;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }   
}
