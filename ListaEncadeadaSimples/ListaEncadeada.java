package ex1Codes;

public class ListaEncadeada {
    private No primeiro;
    private No ultimo;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }// construtor

    public No getPrimeiro() {
        return primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public boolean isEmpty() {
        if (primeiro == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirNoInicio(int valor) {
        No novo = new No(valor);

        if (isEmpty()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro = novo;
        }
    }

    public void inserirNoFinal(int valor) {
        No novo = new No(valor);

        if (isEmpty()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
    }

    public void removerNo(int valor) {
        if (isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }

        No no = primeiro;

        while (no != null) {
            if (no.getNumero() == valor && no == primeiro) {
                primeiro = no.getProximo();
                if (primeiro == null) {
                    ultimo = null;
                }
                return;
            } else if (no.getProximo() != null && no.getProximo().getNumero() == valor
                    && no.getProximo().getProximo() != null) {
                no.setProximo(no.getProximo().getProximo());

                no = no.getProximo();
                return;
            } else if (no.getProximo() != null && no.getProximo().getNumero() == valor
                    && no.getProximo().getProximo() == null) {
                no.setProximo(null);
                ultimo = no;
                return;
            } else {
                no = no.getProximo();
            }
        }
    }

    public String exibirLista() {
        StringBuilder sb = new StringBuilder();

        No no = primeiro;
        while (no != null) {
            if (no.getProximo() == null) {
                sb.append(no.getNumero());
                no = no.getProximo();
            } else {
                sb.append(no.getNumero()).append(" -> ");
                no = no.getProximo();
            }
        }
        return sb.toString();
    }

    public int quantidadePares() {
        int qntPares = 0;

        No no = primeiro;
        while (no != null) {
            if (no.getNumero() % 2 == 0) {
                qntPares++;
                no = no.getProximo();
            }
            no = no.getProximo();

        }
        return qntPares;
    }


    public void inverterLista () {
        No anterior = null;
        No atual = primeiro;
        No proximo = null;

        while (atual != null) {
            proximo = atual.getProximo();
            atual.setProximo(anterior);
            anterior = atual;
            atual = proximo;
        }
        primeiro = anterior;
    }

}// class
