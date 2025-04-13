/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;

/**
 *
 * @author Usuario
 */
public class PilhaLista<T> implements pilha<T> {
    private ListaEncadeada<T> lista;
    
    public PilhaLista () {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        if (lista.estaVazia()) {
            throw new RuntimeException("Lista vazia");
        }
        T variavel = lista.getPrimeiro().getInfo();
        lista.retirar(variavel);
        return variavel;
    }

    @Override
    public T peek() {
        if (lista.estaVazia()) {
            throw new RuntimeException("Lista vazia");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!lista.estaVazia()) {            
            lista.retirar(lista.getPrimeiro().getInfo());
        }
    }

    @Override
    public String toString () {
        return lista.toString();
    }
    
}//class
