package codes;
//Exemplo de pilhas utilizando um simples vetor.


public interface pilha<T> {

    void push (T elemento);

    Object pop ();

    boolean isEmpty ();

    boolean isFull ();

    T top ();

    void liberar ();

    String toString ();

    void concatenar (PilhaVetor<T> p);
    
}//class
