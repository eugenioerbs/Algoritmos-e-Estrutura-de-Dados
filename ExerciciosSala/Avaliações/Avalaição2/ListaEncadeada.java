public class ListaEncadeada<T> {

    private No <T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }//construtor

    public No <T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        No <T> novo = new No <>(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public No <T> buscar(T info) {
        No <T> atual = primeiro;//20
        while (atual != null) {//enquanto não for 0
            if (atual.getInfo().equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        if (primeiro == null) {
            return; // Lista vazia
        }
        if (primeiro.getInfo().equals(info)) {
            primeiro = primeiro.getProximo(); // Remove o primeiro nó
            return;
        }

        No <T> atual = primeiro;
        No <T> anterior = null;

        while (atual != null && !atual.getInfo().equals(info)) {
            anterior = atual;
            atual = atual.getProximo();//20
        }

        if (atual != null) {
            anterior.setProximo(atual.getProximo()); // Remove o nó do meio ou do fim
        }
    }

    public int obterComprimento() { //tipo int que vai retornar o valor total de unidades da lista
        int contador = 0; //1
        No <T> atual = primeiro;
        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }

    public No <T> obterNo(int idx) {
        if (idx < 0 || idx >= obterComprimento()) { // menor que 0 ou Maior que o Total de indices
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido.");
        }

        No <T> no = primeiro;
        for (int i = 0; i < idx; i++) {
            no = no.getProximo();
        }
        return no;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        No <T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }

    //Foram adicionados os dois IFs de verificação para caso de IndexOutBounsException que por discuido
    //não adicionei no meu fluxograma;
    public ListaEncadeada<T> criarSubLista(int inicio, int fim) {
        ListaEncadeada<T> subLista = new ListaEncadeada<>();
        No <T> p = primeiro;
        int contador = 0;

        if (inicio < 0 || fim < inicio) {
            throw new IndexOutOfBoundsException();

        }

        while (p != null && contador < inicio) {
            p = p.getProximo();
            contador++;

        }

        if (p == null) {
            throw new IndexOutOfBoundsException();

        }

        while (p != null && contador <= fim) {
            subLista.inserir(p.getInfo());
            p = p.getProximo();
            contador++;

        }

        return subLista;
    }

}//class
