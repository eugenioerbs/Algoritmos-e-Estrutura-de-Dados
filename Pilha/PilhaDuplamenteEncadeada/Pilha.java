/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Pilha {
    private No primeiro;
    private No ultimo;

    public Pilha() {
        this.primeiro = null;
        this.ultimo = null;
    }// construtor

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public No getUltimo() {
        return ultimo;
    }

    public boolean isEmpty() {
        return primeiro == null && ultimo == null;
    }

    public void push(char letra) {
        No novoNo = new No(letra);

        if (isEmpty()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            novoNo.setAnterior(ultimo);
            ultimo = novoNo;
        }
    }

    public No pop() {
        No ultimoResgatado = ultimo;

        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        if (ultimo.getAnterior() != null) {
            ultimo.getAnterior().setProximo(null);
            ultimo = ultimo.getAnterior();
        } else {
            ultimo = null;
            primeiro = null;
        }

        return ultimoResgatado;
    }

    public No top() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        return ultimo;
    }

    public int size() {
        No noPercorrendo = primeiro;
        int tamanhoDaPilha = 0;

        while (noPercorrendo != null) {
            tamanhoDaPilha += 1;
            noPercorrendo = noPercorrendo.getProximo();
        }

        return tamanhoDaPilha;
    }

    public String exibirNormal() {
        StringBuilder sb = new StringBuilder();
        No noPercorrendo = primeiro;

        while (noPercorrendo != null) {
            sb.append(noPercorrendo.getLetra());

            noPercorrendo = noPercorrendo.getProximo();
        }
        return sb.toString();
    }

    public String exibirInverso() {
        StringBuilder sb = new StringBuilder();
        No noPercorrendo = ultimo;

        while (noPercorrendo != null) {
            sb.append(noPercorrendo.getLetra());

            noPercorrendo = noPercorrendo.getAnterior();
        }
        return sb.toString();
    }
    
    public boolean verificarPalindromo () {
        return exibirNormal().equalsIgnoreCase(exibirInverso());
    }
    
    
    
    

}// class

