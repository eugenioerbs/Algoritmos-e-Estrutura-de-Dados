
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */

public class ListDupla<T> {
    private NoListaDupla<T> primeiro;
     
    public ListDupla() {
        this.primeiro = null;
    }//construtor

    
    
    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }
    
    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);
        novo.setProximo(primeiro);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }
    
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null; //não encontrou
    }
    
    public void retirar (T valor) {
        NoListaDupla<T> atual = buscar(valor);
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "O valor não existe na lista");
            return;
        }
        if (atual.getAnterior() != null) {
            atual.getAnterior().setProximo(atual.getProximo());
        } else {
            primeiro = atual.getProximo();
        }
        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(atual.getAnterior());
        }
    }
    
    public void exibirOrdemInversa () {
        NoListaDupla<T> atual = primeiro;
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "O valor não existe na lista");
            return;
        }
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        while (atual != null) {
            JOptionPane.showMessageDialog(null, atual.getInfo() + " ");
            atual = atual.getAnterior();
        }
    }
    
    public void liberar () {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual = proximo;
        }
        primeiro = null;
    }
    
    public String toString () {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
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
