package Fila;

public class No<T> {
    private T info;
    private No<T> anterior;
    private No<T> proximo;

    public No (T info) {
        this.info = info;
        this.anterior = null;
        this.proximo = null;
    }//construtor

    public void setInfo (T info) {
        this.info =  info;
    }

    public T getInfo () {
        return info;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getProximo() {
        return proximo;
    }
    
 }//class
