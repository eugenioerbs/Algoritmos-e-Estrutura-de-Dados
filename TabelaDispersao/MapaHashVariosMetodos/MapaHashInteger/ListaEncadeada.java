package TabelaDispersao;

public class ListaEncadeada {
    private No primeiro;
    private No ultimo;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }// construtor

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public No getUltimo() {
        return ultimo;
    }

    public boolean estaVazia() {
        return (primeiro == null) && (ultimo == null);
    }

    public void inserir(int chave, String name) {
        No novo = new No(chave, name);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            novo.setProximo(null);
            ultimo = novo;
        }
    }

    public void remover(int chave, String name) {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia!");
        }

        if (chave < 0 || name.equals("")) {
            throw new RuntimeException("Dados não informados");
        }

        No noPercorrendo = primeiro;
        boolean found = false;

        while (noPercorrendo != null && !found) {
            if (noPercorrendo.getChave() == chave && noPercorrendo.getName().equalsIgnoreCase(name)) {
                remover(noPercorrendo);
                found = true;
            }
            noPercorrendo = noPercorrendo.getProximo();
        }
    }

    private void remover(No no) {
        if (no == primeiro && no == ultimo) {
            primeiro = null;
            ultimo = null;
        } else if (no == primeiro) {
            primeiro = primeiro.getProximo();
            primeiro.setAnterior(null);
        } else if (no == ultimo) {
            ultimo = ultimo.getAnterior();
            ultimo.setProximo(null);
        } else {
            no.getAnterior().setProximo(no.getProximo());
            no.getProximo().setAnterior(no.getAnterior());
        }
    }

    public No buscar(int chave) {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia!");
        }

        No noPercorrendo = primeiro;

        while (noPercorrendo != null) {
            if (noPercorrendo.getChave() == chave) {
                return noPercorrendo;
            }
            noPercorrendo = noPercorrendo.getProximo();
        }
        return null;
    }

    public String exibir () {
        if (estaVazia())
        throw new RuntimeException("Lista vazia!");

        No noPercorrendo = primeiro;
        StringBuilder sb = new StringBuilder();
        
        while (noPercorrendo != null) {
            if (noPercorrendo.getProximo() != null) {
                sb.append("Chave: ").append(noPercorrendo.getChave()).append(", Name: ")
                        .append(noPercorrendo.getName()).append(" - ");
                noPercorrendo = noPercorrendo.getProximo();
            } else {
                sb.append("Chave: ").append(noPercorrendo.getChave()).append(", Name: ")
                        .append(noPercorrendo.getName());
                noPercorrendo = noPercorrendo.getProximo();
            }
        }
        return sb.toString();
    }


    

}// class
