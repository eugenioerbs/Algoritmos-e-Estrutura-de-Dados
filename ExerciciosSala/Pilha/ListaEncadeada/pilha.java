/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;

/**
 *
 * @author Usuario
 */
public interface pilha<T> {
    
    void push(T info);
    T pop();
    T peek();
    boolean estaVazia();
    void liberar();
}
