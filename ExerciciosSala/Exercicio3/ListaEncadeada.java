/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;

/**
 *
 * @author Usuario
 */
public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }//construtor

    
    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> atual = primeiro;//20
        while (atual != null) {//enquanto não for 0
            if (atual.getInfo().equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        if (primeiro == null) {
            return; // Lista vazia
        }
        if (primeiro.getInfo().equals(info)) {
            primeiro = primeiro.getProximo(); // Remove o primeiro nó
            return;
        }

            NoLista<T> atual = primeiro;
            NoLista<T> anterior = null;

            while (atual != null && !atual.getInfo().equals(info)) {
                anterior = atual;
                atual = atual.getProximo();//20
            }

            if (atual != null) {
                anterior.setProximo(atual.getProximo()); // Remove o nó do meio ou do fim
            }
        }

    public int obterComprimento() { //tipo int que vai retornar o valor total de unidades da lista
        int contador = 0; //1
        NoLista<T> atual = primeiro;
        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0 || idx >= obterComprimento()) { // menor que 0 ou Maior que o Total de indices
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido.");
        }

        NoLista<T> no = primeiro; 
        for (int i = 0; i < idx; i++) {
            no = no.getProximo();
        }
        return no;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }

    
}//class
