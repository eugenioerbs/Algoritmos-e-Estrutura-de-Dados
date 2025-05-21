package Fila;

public class FilaEstatica {
    private int capacidade; // capacidade
    private int[] vetor;
    private int aqui; // onde vai ser alocado sempre
    private int primeiro; // primeiro item
    private int adicionados; // numero de elementos na fila

    public FilaEstatica(int capacidade) {
        this.capacidade = capacidade;
        vetor = new int[capacidade];
        this.aqui = -1;
        this.primeiro = 0;
        this.adicionados = 0;
    }// construtor

    public boolean estaVazia() {
        return adicionados == 0;
    }

    public boolean estaCheia() {
        return adicionados == capacidade;
    }

    public boolean enfileirar(int valor) { // retorna false se vetor cheio, ou true se adicionado.
        if (estaCheia()) {
            return false;
        }

        aqui = (aqui + 1) % vetor.length;
        vetor[aqui] = valor;
        adicionados++;
        return true;
    }

    public int desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }

        int valor = vetor[primeiro];
        primeiro = (primeiro + 1) % capacidade;
        adicionados--;
        return valor;
    }

    public int peek() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }

        return vetor[primeiro];
    }

    public String mostrarFila() {
        StringBuilder sb = new StringBuilder();

        if (estaVazia()) {
            return "Fila vazia";
        }

        for (int i = 0; i < adicionados; i++) {
            int indice = (primeiro + i) % capacidade;
            sb.append(vetor[indice]);
            if (i < adicionados - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}// class
