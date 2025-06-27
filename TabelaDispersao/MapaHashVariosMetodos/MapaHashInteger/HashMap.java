package TabelaDispersao;

public class HashMap {
    private ListaEncadeada[] vetor;
    private int tamanho;

    public HashMap(int tamanho) {
        this.tamanho = tamanho;
        vetor = new ListaEncadeada[tamanho];
    }// construtor

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    private int calcularHash(int chave) {
        return chave % tamanho;
    }

    public void inserir(int chave, String name) {
        int indice = calcularHash(chave); // cálculo o índice e armazeno nesta variavel

        if (vetor[indice] == null) {// caso o indice do vetor esteja sem lista
            ListaEncadeada listaNova = new ListaEncadeada(); // instancia a lista
            vetor[indice] = listaNova; // coloco ela no vetor
        }
        vetor[indice].inserir(chave, name);
    }

    public String buscar(int chave) {
        int indice = calcularHash(chave);

        if (vetor[indice] != null) {
            No no = vetor[indice].buscar(chave);
            if (no != null) {
                return no.getName();
            }
        }
        return null;
    }

    public void remover(int chave, String name) {
        int indice = calcularHash(chave);

        if (vetor[indice] != null) {
            vetor[indice].remover(chave, name);
        } else {
            throw new RuntimeException("Este índice esta vazio!");
        }
    }

    public String exibir() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            sb.append("[").append(i).append("]: ");

            if (vetor[i] != null && !vetor[i].estaVazia()) {
                No noPercorrendo = vetor[i].getPrimeiro();

                while (noPercorrendo != null) {
                    if (noPercorrendo.getProximo() == null) {
                        sb.append("(Chave = ").append(noPercorrendo.getChave()).append(" Nome = ")
                                .append(noPercorrendo.getName()).append(")");
                    } else {
                        sb.append("(Chave = ").append(noPercorrendo.getChave()).append(" Nome = ")
                                .append(noPercorrendo.getName()).append(")").append(" -> ");
                    }
                    noPercorrendo = noPercorrendo.getProximo();
                }

            } else {
                sb.append("Vazia");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean noExiste(int chave) {
        int indice = calcularHash(chave);

        if (vetor[indice] == null || vetor[indice].estaVazia()) {
            throw new RuntimeException("índice não existe no mapa!");

        }

        No noAtual = vetor[indice].getPrimeiro();

        while (noAtual != null) {
            if (noAtual.getChave() == chave) {
                return true;

            } else {
                noAtual = noAtual.getProximo();
            }
        }

        return false;
    }

    public void limparMapa() {
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = null;
        }
    }

    public String fatorCarga() {
        StringBuilder sb = new StringBuilder();
        sb.append(fatorDeCarga()).append("%");
        return sb.toString();
    }

    private double fatorDeCarga() {
        int totalElementos = 0;

        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] != null && !vetor[i].estaVazia()) {
                No atual = vetor[i].getPrimeiro();
                while (atual != null) {
                    totalElementos++;
                    atual = atual.getProximo();
                }
            }
        }

        return (double) totalElementos / tamanho;
    }

    public int indicesOcupados() {
        int ocupados = 0;

        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] != null && !vetor[i].estaVazia()) {
                ocupados++;
            }
        }
        return (ocupados * 100) / tamanho;
    }

    public String exibirTalIndice(int indice) {
        StringBuilder sb = new StringBuilder();

        if (vetor[indice] == null && vetor[indice].estaVazia())
            throw new RuntimeException("Este índice não exixte no mapa!");

        sb.append("[").append(indice).append("]: ");

        No noAtual = vetor[indice].getPrimeiro();

        while (noAtual != null) {
            if (noAtual.getProximo() != null) {
                sb.append("(Chave = ").append(noAtual.getChave()).append(", Name = ").append(noAtual.getName())
                        .append(") -> ");
            } else {
                sb.append("(Chave = ").append(noAtual.getChave()).append(", Name = ").append(noAtual.getName())
                        .append(")");
            }
            noAtual = noAtual.getProximo();
        }
        return sb.toString();
    }

    public int contarNos() {
        int soma = 0;

        for (int i = 0; i < tamanho; i++) {

            if (vetor[i] != null && !vetor[i].estaVazia()) {
                No noPercorrendo = vetor[i].getPrimeiro();

                while (noPercorrendo != null) {
                    soma++;
                    noPercorrendo = noPercorrendo.getProximo();
                }
            }
        }
        return soma;
    }

    public int contarNosdaListaTal(int indice) {
        int soma = 0;
        if (vetor[indice] == null && vetor[indice].estaVazia())
            throw new RuntimeException("Este índice não exixte no mapa!");

        No noAtual = vetor[indice].getPrimeiro();

        while (noAtual != null) {
            soma++;
            noAtual = noAtual.getProximo();
        }

        return soma;
    }

    public No atualizarNome(int chave, String name) {
        int indice = calcularHash(chave);
        boolean achou = false;

        if (vetor[indice] == null || vetor[indice].estaVazia()) {
            throw new RuntimeException("índice não existe no mapa!");

        }

        No noAtual = vetor[indice].getPrimeiro();

        while (noAtual != null && achou == false) {
            if (noAtual.getChave() == chave) {
                noAtual.setName(name);
                achou = true;

            } else {
                noAtual = noAtual.getProximo();
            }
        }

        return noAtual;
    }

    public int contarColisoes() {
        int colisoes = 0;

        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] != null) {
                int qntNosLista = 0;

                No noAtual = vetor[i].getPrimeiro();

                while (noAtual != null) {
                    qntNosLista++;
                    noAtual = noAtual.getProximo();
                }

                if (qntNosLista > 1) {
                    colisoes = colisoes + (qntNosLista - 1);
                }
            }
        }
        return colisoes;
    }

    public HashMap clonar() {
        HashMap novoMapa = new HashMap(this.getTamanho());

        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] != null) {
                No noAtual = vetor[i].getPrimeiro();
                while (noAtual != null) {
                    novoMapa.inserir(noAtual.getChave(), noAtual.getName());
                    noAtual = noAtual.getProximo();
                }
            }
        }
        return novoMapa;
    }

    public void unir(HashMap outroMapa) {
        for (int i = 0; i < outroMapa.getTamanho(); i++) {
            ListaEncadeada lista = outroMapa.vetor[i];
            if (lista != null && !lista.estaVazia()) {
                No noAtual = lista.getPrimeiro();
                while (noAtual != null) {
                    this.inserir(noAtual.getChave(), noAtual.getName());
                    noAtual = noAtual.getProximo();
                }
            }
        }
    }

    public int obterMaiorChave() {
        int maior = Integer.MIN_VALUE;
        for (int i = 0; i < tamanho; i++) {

            if (vetor[i] != null && !vetor[i].estaVazia()) {
                No no = vetor[i].getPrimeiro();

                while (no != null) {

                    if (no.getChave() > maior) {
                        maior = no.getChave();
                    }
                    no = no.getProximo();
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
        for (int i = 0; i < tamanho; i++) {

            if (vetor[i] != null && !vetor[i].estaVazia()) {
                No no = vetor[i].getPrimeiro();

                while (no != null) {

                    if (no.getChave() < menor) {
                        menor = no.getChave();
                    }
                    no = no.getProximo();
                }
            }
        }

        if (menor == Integer.MIN_VALUE) {
            throw new RuntimeException("Mapa vazio");
        }

        return menor;
    }

    public void redimencionar() {
        int novoTamanho = proximoPrimo(tamanho * 2);
        HashMap novoMapa = new HashMap(novoTamanho);

        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] != null) {
                No no = vetor[i].getPrimeiro();

                while (no != null) {
                    novoMapa.inserir(no.getChave(), no.getName());
                    no = no.getProximo();
                }
            }
        }
        this.vetor = novoMapa.vetor;
        this.tamanho = novoMapa.getTamanho();
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

}// class
