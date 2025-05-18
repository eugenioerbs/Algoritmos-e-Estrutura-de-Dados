/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class No {
    private char letra;
    private No anterior;
    private No proximo;

    public No(char letra) {
        this.letra = letra;
        this.anterior = null;
        this.proximo = null;
    }// construtor

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public char getLetra() {
        return letra;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }


}// class

