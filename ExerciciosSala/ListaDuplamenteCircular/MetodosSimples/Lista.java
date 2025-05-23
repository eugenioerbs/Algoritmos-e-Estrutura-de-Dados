package ListaCircular;

public class Lista<T> {
    private No<T> inicio;
    private int tamanho = 0;



    public void inserir(T valor) {
        No<T> novo = new No<>(valor);

        if (inicio == null) {
            inicio = novo;
            inicio.setProximo(inicio);
            inicio.setAnterior(inicio);
            
        } else {
            No<T> ultimo = inicio.getAnterior();
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
        }
        tamanho++;
    }

    public void remover(T valor) {
        if (inicio == null) {
            return;
        }

        No<T> atual = inicio;
 
        do {
            if (atual.getInfo().equals(valor)) {
                if (atual == inicio && tamanho == 1) {
                    inicio = null;
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                    if (atual == inicio) {
                        inicio = atual.getProximo();
                    }
                } 
                tamanho--;
                return;
            } 
            atual = atual.getProximo();
        } while (atual != inicio);
    }



    public int getTamanho() {
        return tamanho;
    }



    public String exibir () {
        if (inicio == null) {
            //JOPtion ou print informando que a lista ta vazia...
            return "Lista vazia";
        }
        StringBuilder sb = new StringBuilder();
        No<T> noAtual = inicio;
        do {
            sb.append(noAtual.getInfo() + " <-> ");
            noAtual = noAtual.getProximo();
        } while (noAtual != inicio);    
        return sb.toString(); 
    }


    public boolean estaVazia () {
        return inicio == null;
    }



}// class

