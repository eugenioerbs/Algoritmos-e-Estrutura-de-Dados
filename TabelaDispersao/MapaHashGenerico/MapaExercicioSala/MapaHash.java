package TabelaDispersaoProf;

public class MapaHash<T> {
    private ListaEncadeada<No<T>>[] vetor;
    private int size;

    public MapaHash(int size) {
        this.size = size;
        vetor = (ListaEncadeada<No<T>>[]) new ListaEncadeada[size];

        for (int i = 0; i < size; i++) {
            vetor[i] = new ListaEncadeada<>();
        }
    }// construtor

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int calculateHash(int key) {
        return key % size;
    }

    public void insert(int chave, T info) {
        int index = calculateHash(chave);
        No<T> no = new No<>(chave, info);

        vetor[index].insert(no);
    }

    public String showIt() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append("[").append(i).append("]: ");

            if (vetor[i] != null && !vetor[i].isEmpty()) {
                No noPercorrendo = vetor[i].getFirst();

                while (noPercorrendo != null) {
                    Aluno aluno = (Aluno) noPercorrendo.getInfo(); // cast para extrair aluno de info;

                    if (noPercorrendo.getNext() == null) {
                        sb.append("(Registration = ").append(aluno.getRegistration()).append(" Name = ")
                                .append(aluno.getName()).append(")");

                    } else {
                        sb.append("(Registration = ").append(aluno.getRegistration()).append(" Name = ")
                                .append(aluno.getName()).append(")").append(" -> ");

                    }
                    noPercorrendo = noPercorrendo.getNext();
                }

            } else {
                sb.append("Vazia");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String buscar(int chave) {
        int indice = calculateHash(chave);

        if (vetor[indice] != null) {
            No no = vetor[indice].buscar(chave);
            Aluno aluno = (Aluno) no.getInfo(); // cast

            /*
             * Se caso não ser um objeto Aluno de certeza; tratar cada tipo de objeto
             * exclusivamente;
             * if (objeto instanceof Aluno aluno) { // Java 16+ com pattern matching
             * System.out.println(aluno.getName());
             * } else {
             * System.out.println("Não é um aluno.");
             * }
             */

            if (no != null) {
                return aluno.getName();
            }
        }
        return null;
    }

    public void remover(int chave) {
        int indice = calculateHash(chave);

        if (vetor[indice] != null) {
            vetor[indice].remover(chave);
        } else {
            throw new RuntimeException("Este índice esta vazio!");
        }
    }

    public boolean noExiste(int chave) {
        int indice = calculateHash(chave);

        if (vetor[indice] == null || vetor[indice].isEmpty()) {
            throw new RuntimeException("índice não existe no mapa!");

        }

        No noAtual = vetor[indice].getFirst();

        while (noAtual != null) {
            if (noAtual.getKey() == chave) {
                return true;

            } else {
                noAtual = noAtual.getNext();
            }
        }

        return false;
    }

    public void limparMapa() {
        for (int i = 0; i < size; i++) {
            vetor[i] = null;
        }
    }

    public String porcentegemOcupacaoString() {
        StringBuilder sb = new StringBuilder();
        sb.append(porcentegemOcupacao()).append("%");
        return sb.toString();
    }

    private double porcentegemOcupacao() {
        int ocupados = 0;

        for (int i = 0; i < size; i++) {
            if (vetor[i] != null && !vetor[i].isEmpty()) {
                ocupados++;
            }
        }
        return (ocupados * 100.0) / size;
    }

    public String exibirTalIndice(int indice) {
        StringBuilder sb = new StringBuilder();

        if (vetor[indice] == null && vetor[indice].isEmpty())
            throw new RuntimeException("Este índice não exixte no mapa!");

        sb.append("[").append(indice).append("]: ");

        No noAtual = vetor[indice].getFirst();
        Aluno aluno = (Aluno) noAtual.getInfo();

        while (noAtual != null) {
            if (noAtual.getNext() != null) {
                sb.append("(Registration = ").append(aluno.getRegistration()).append(", Name = ")
                        .append(aluno.getName())
                        .append(") -> ");
            } else {
                sb.append("(Registration = ").append(aluno.getRegistration()).append(", Name = ")
                        .append(aluno.getName())
                        .append(")");
            }
            noAtual = noAtual.getNext();
        }
        return sb.toString();
    }

    public int contarNos() {
        int soma = 0;

        for (int i = 0; i < size; i++) {

            if (vetor[i] != null && !vetor[i].isEmpty()) {
                No noPercorrendo = vetor[i].getFirst();

                while (noPercorrendo != null) {
                    soma++;
                    noPercorrendo = noPercorrendo.getNext();
                }
            }
        }
        return soma;
    }

    public int contarNosdaListaTal(int indice) {
        int soma = 0;
        if (vetor[indice] == null && vetor[indice].isEmpty())
            throw new RuntimeException("Este índice não exixte no mapa!");

        No noAtual = vetor[indice].getFirst();

        while (noAtual != null) {
            soma++;
            noAtual = noAtual.getNext();
        }

        return soma;
    }

    public No atualizarNome(int chave, String name) {
        int indice = calculateHash(chave);
        boolean achou = false;

        if (vetor[indice] == null || vetor[indice].isEmpty()) {
            throw new RuntimeException("índice não existe no mapa!");

        }

        No noAtual = vetor[indice].getFirst();
        Aluno aluno = (Aluno) noAtual.getInfo();

        while (noAtual != null && achou == false) {
            if (noAtual.getKey() == chave) {
                aluno.setName(name);
                achou = true;

            } else {
                noAtual = noAtual.getNext();
            }
        }

        return noAtual;
    }

    public int contarColisoes() {
        int colisoes = 0;

        for (int i = 0; i < size; i++) {
            if (vetor[i] != null) {
                int qntNosLista = 0;

                No noAtual = vetor[i].getFirst();

                while (noAtual != null) {
                    qntNosLista++;
                    noAtual = noAtual.getNext();
                }

                if (qntNosLista > 1) {
                    colisoes = colisoes + (qntNosLista - 1);
                }
            }
        }
        return colisoes;
    }

    public MapaHash clonar() {
        MapaHash novoMapa = new MapaHash(this.getSize());

        for (int i = 0; i < size; i++) {
            if (vetor[i] != null) {
                No noAtual = vetor[i].getFirst();

                while (noAtual != null) {
                    novoMapa.insert(noAtual.getKey(), noAtual.getInfo());
                    noAtual = noAtual.getNext();
                }
            }
        }
        return novoMapa;
    }

    public void unir(MapaHash outroMapa) {
        for (int i = 0; i < outroMapa.getSize(); i++) {
            ListaEncadeada<T> lista = outroMapa.vetor[i];

            if (lista != null && !lista.isEmpty()) {
                No<T> noAtual = lista.getFirst();

                while (noAtual != null) {
                    this.insert(noAtual.getKey(), noAtual.getInfo());
                    noAtual = noAtual.getNext();
                }
            }
        }
    }

    //////////////////////////
    public void unirSemSobrescrever(MapaHash outroMapa) {
        for (int i = 0; i < outroMapa.getSize(); i++) {
            ListaEncadeada<T> lista = outroMapa.vetor[i];

            if (lista != null && !lista.isEmpty()) {
                No<T> noAtual = lista.getFirst();

                while (noAtual != null) {
                    // Só insere se a chave ainda não estiver no mapa atual
                    if (this.search(noAtual.getKey()) == -1) {
                        this.insert(noAtual.getKey(), noAtual.getInfo());
                    }
                    noAtual = noAtual.getNext();
                }
            }
        }
    }

    /////////////////////////
    public int search(int key) {
        int indice = calculateHash(key);
        ListaEncadeada<T> lista = (ListaEncadeada<T>) vetor[indice];

        if (lista != null) {
            No<T> atual = lista.getFirst();

            while (atual != null) {
                if (atual.getKey() == key) {
                    Aluno aluno = (Aluno) atual.getInfo();
                    return aluno.getRegistration(); // encontrou a chave
                }
                atual = atual.getNext();
            }
        }

        return -1; //não encontrou a chave
    }

    public int obterMaiorChave() {
        int maior = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {

            if (vetor[i] != null && !vetor[i].isEmpty()) {
                No no = vetor[i].getFirst();

                while (no != null) {

                    if (no.getKey() > maior) {
                        maior = no.getKey();
                    }
                    no = no.getNext();
                }
            }
        }

        if (maior == Integer.MIN_VALUE) {
            throw new RuntimeException("Mapa vazio");
        }

        return maior;
    }

    public int obterMenorChave() {
        int menor = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {

            if (vetor[i] != null && !vetor[i].isEmpty()) {
                No no = vetor[i].getFirst();

                while (no != null) {

                    if (no.getKey() < menor) {
                        menor = no.getKey();
                    }
                    no = no.getNext();
                }
            }
        }

        if (menor == Integer.MIN_VALUE) {
            throw new RuntimeException("Mapa vazio");
        }

        return menor;
    }

    public void redimencionar() {
        int novoTamanho = proximoPrimo(size * 2);
        MapaHash novoMapa = new MapaHash(novoTamanho);

        for (int i = 0; i < size; i++) {
            if (vetor[i] != null) {
                No no = vetor[i].getFirst();

                while (no != null) {
                    novoMapa.insert(no.getKey(), no.getInfo());
                    no = no.getNext();
                }
            }
        }
        this.vetor = novoMapa.vetor;
        this.size = novoMapa.getSize();
    }

    private boolean ehPrimo(int numero) {
        if (numero < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0)
                return false;
        }
        return true;
    }

    private int proximoPrimo(int num) {
        while (!ehPrimo(num)) {
            num++;
        }
        return num;
    }

    public String fatorCarga() {
        StringBuilder sb = new StringBuilder();
        sb.append(fatorDeCarga()).append("%");
        return sb.toString();
    }

    private double fatorDeCarga() {
        int totalElementos = 0;

        for (int i = 0; i < size; i++) {
            if (vetor[i] != null && !vetor[i].isEmpty()) {
                No atual = vetor[i].getFirst();
                while (atual != null) {
                    totalElementos++;
                    atual = atual.getNext();
                }
            }
        }

        return (double) totalElementos / size;
    }

}// class
