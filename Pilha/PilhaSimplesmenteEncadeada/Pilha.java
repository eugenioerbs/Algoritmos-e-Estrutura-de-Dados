/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PilhaEncadeada;

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
            ultimo = novoNo;
        }
    }

    public No pop() {
        No ultimoResgatado = ultimo;

        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            No noPercorrendo = primeiro;

            while (noPercorrendo.getProximo().getProximo() != null) {
                noPercorrendo = noPercorrendo.getProximo();
            }

            noPercorrendo.setProximo(null);
            ultimo = noPercorrendo;
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
        int contador = 0;
        No noPercorrendo = primeiro;
   
        while (noPercorrendo != null) {
            contador++;
            noPercorrendo = noPercorrendo.getProximo();
        }
        
        No noPercorrer2 = primeiro;
        
        Character[] vetor = new Character[contador];
        
        for (int a = 0; a <= contador - 1; a++) {
            vetor[a] = noPercorrer2.getLetra();
            noPercorrer2 = noPercorrer2.getProximo();
        }
        
        for (int a = vetor.length - 1; a >= 0; a--) {
            sb.append(vetor[a]);
        }
        return sb.toString();
    }

    public boolean verificarPalindromo() {
        return exibirNormal().equalsIgnoreCase(exibirInverso());
    }

}// class
