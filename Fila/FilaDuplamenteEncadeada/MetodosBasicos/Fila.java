package Fila;

public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
    }// construtor

    public void setPrimeiro(No<T> primeiro) {
        this.primeiro = primeiro;
    }

    public No<T> getPrimeiro() {
        return primeiro;
    }

    public void setUltimo(No<T> ultimo) {
        this.ultimo = ultimo;
    }

    public No<T> getUltimo() {
        return ultimo;
    }

    public boolean isEmpty() {
        return primeiro == null && ultimo == null;
    }

    public void inserirFinal(T info) {
        No<T> novo = new No<>(info);

        if (isEmpty()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
    }

    
    public No<T> removerERetornar() {
        No<T> retornoMetodo = primeiro;

        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        primeiro = primeiro.getProximo();

        if (primeiro == null) {
            ultimo = null;
        }

        if (primeiro != null) {
            primeiro.setAnterior(null);
        }
        return retornoMetodo;
    }


    public No<T> retornarInicio() {
        return primeiro;
    }

    public String exibirCerto() {
        StringBuilder sb = new StringBuilder();
        No<T> noAtual = primeiro;

        while (noAtual != null) {
            if (noAtual.getProximo() != null) {
                sb.append(noAtual.getInfo()).append(" <-> ");
            } else {
                sb.append(noAtual.getInfo());
            }
            noAtual = noAtual.getProximo();
        }
        return sb.toString();
    }


    public String exibirInversamente () {
        StringBuilder sb = new StringBuilder();
        No<T> noPercorrendo = ultimo;

        while (noPercorrendo != null) {
            if (noPercorrendo.getAnterior() != null) {
                sb.append(noPercorrendo.getInfo()).append("<->");
            } else {
                sb.append(noPercorrendo.getInfo());
            }
            noPercorrendo = noPercorrendo.getAnterior();
        }
        return sb.toString();
    }

    
}// class
