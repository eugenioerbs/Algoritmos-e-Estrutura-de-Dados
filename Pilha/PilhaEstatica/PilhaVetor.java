package codes;

public class PilhaVetor<T> implements pilha<T> {
    private Object vetor [];
    private int indiceMaximo;
    private int topo;

    public PilhaVetor (int indiceMaximo) {
        this.indiceMaximo = indiceMaximo;
        this.vetor = new Object[indiceMaximo];
        this.topo = 0;

    }//construtor


    @Override
    public void push (T elemento) {
        if (topo == indiceMaximo) {
            throw new RuntimeException("Pilha cheia");
        } else {
            vetor[topo] = elemento;
            topo++;
        }
    }

    @Override
    public T pop () {
        if (isEmpty()) {
            throw new  RuntimeException("Pilha Vazia");
        } 
        topo--;
        return (T) vetor[topo];
    }

    @Override
    public T top () {
        if (isEmpty()) {
            throw new  RuntimeException("Pilha Vazia");
        }
        return (T) vetor[topo - 1];
    }

    @Override
    public boolean isEmpty() {
        return topo == 0;
    }

    @Override
    public void liberar () {
        topo = 0;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder();
        for (int i = topo-1; i >=0; i--) {
            s.append(vetor[i]);
            if (i > 0) {
                s.append(", ");
            }
        }
        return s.toString();
    }

    @Override
    public void concatenar (PilhaVetor<T> p) {
        if (this.topo + p.topo > this.indiceMaximo) {
            throw new RuntimeException("Pilha cheia");
        }

        Object[] vetTemporario = new Object[p.topo];
        for (int i = 0; i <= p.topo; i++) {
            vetTemporario[i] = p.vetor[i];
        }

        for (int i = 0; i <= p.topo; i++) {
            this.push((T) vetTemporario[i]);
        }
    }

    @Override
    public boolean isFull () {
        return topo == indiceMaximo;
    }
    

}// class
