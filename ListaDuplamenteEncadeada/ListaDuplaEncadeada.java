package ex2Codes;

public class ListaDuplaEncadeada {
    private No primeiro;
    private No ultimo;


    public ListaDuplaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }// constructor


    public No getPrimeiro() {
        return primeiro;
    }


    public No getLast() {
        return ultimo;
    }


    public boolean isEmpty() {
        return primeiro == null;
    }


    public void inserir(String name) {
        No novo = new No(name);

        if (isEmpty()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
    }


    public void removerNome(String nome) {
        if (isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }

        No no = primeiro;

        while (no != null) {
            No proximo = no.getProximo();

            if (no.getName().equalsIgnoreCase(nome)) {
                if (no == primeiro && no == ultimo) {
                    primeiro = null;
                    ultimo = null;
                } else if (no == primeiro) {
                    no.getProximo().setAnterior(null);
                    no = null;
                } else if (no == ultimo) {
                    no.getAnterior().setProximo(null);
                    no = null;
                } else {
                    no.getAnterior().setProximo(no.getProximo());
                    no.getProximo().setAnterior(no.getAnterior());
                    no = null;
                }
            } else {
                no = proximo;
            }
            no = proximo;
        }
    }


    public String exibirListaDoIncio() {
        StringBuilder sb = new StringBuilder();

        No no = primeiro;

        while (no != null) {
            No proximo = no.getProximo();

            if (no.getProximo() != null) {
                sb.append(no.getName()).append(" <-> ");
            } else {
                sb.append(no.getName());
            }
            no = proximo;
        }
        return sb.toString();
    }


    public String exibirListaDoFinal () {
        StringBuilder sb = new StringBuilder();

        if (isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }

        No no = ultimo;

        while (no != null) {
            No anterior = no.getAnterior();

            if (no.getAnterior() != null) {
                sb.append(no.getName()).append("<->");
            } else {
                sb.append(no.getName());
            }
            no = anterior;
        }

        return sb.toString();
    }


    public boolean existe (String nome) {
        No no = primeiro;
        if (isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }

        while (no != null) {
            No proximo = no.getProximo();
            if (no.getName().equalsIgnoreCase(nome)) {
                return true;
            } else {
                no = proximo;
            }
        }
        return false;
    }


    public String thanStartWith (String letra) {
        if (isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }

        StringBuilder sb = new StringBuilder();
        No no = primeiro;

        while (no != null) {
            No proximo = no.getProximo();
            if (no.getName().toUpperCase()  .startsWith(letra)) {
                if (no.getProximo() != null) {
                    sb.append(no.getName()).append(" - ");
                } else {
                    sb.append(no.getName());
                }
            }
            no = proximo;
        }
        return sb.toString();
    }

    
    public void removerNomeThanStartWith(String letra) {
        if (isEmpty()) {
            throw new RuntimeException("Lista Vazia");
        }

        No no = primeiro;

        while (no != null) {
            No proximo = no.getProximo();

            if (no.getName().toUpperCase().startsWith(letra)) {
                if (no == primeiro && no == ultimo) {
                    primeiro = null;
                    ultimo = null;
                } else if (no == primeiro) {
                    no.getProximo().setAnterior(null);
                    no = null;
                } else if (no == ultimo) {
                    no.getAnterior().setProximo(null);
                    no = null;
                } else {
                    no.getAnterior().setProximo(no.getProximo());
                    no.getProximo().setAnterior(no.getAnterior());
                    no = null;
                }
            } else {
                no = proximo;
            }
            no = proximo;
        }
    }

}// class
