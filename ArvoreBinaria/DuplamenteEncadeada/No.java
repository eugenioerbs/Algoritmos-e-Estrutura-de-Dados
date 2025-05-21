package ArvoreBinária;

public class No<T> {
    private T info;
    private No<T> esquerda;
    private No<T> direita;

    public No (T info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }//construtor

    public No (T info, No<T> esquerda, No<T> direita) {
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }//construtor 1 gfolha

    public void setInfo (T info) {
        this.info = info;
    }//construtor 2 raiz

    public T getInfo () {
        return info;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }

    public No<T> getDireita() {
        return direita;
    }

    
}//classe 
