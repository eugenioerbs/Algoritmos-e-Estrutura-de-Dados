package QuickSort;

public class MetodoQuick {

    public void quickSort(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private void quickSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int p = particao(vetor, esquerda, direita);
            quickSort(vetor, esquerda, p);
            quickSort(vetor, p + 1, direita);
        }
    }

    private int particao(int[] vetor, int esquerda, int direita) {
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while (true) {
            do {
                i++;
            } while (vetor[i] < pivot);

            do {
                j--;
            } while (vetor[j] > pivot);

            if (i >= j) {
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }

    public String exibirVetor(int[] vetor) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vetor.length; i++) {
            sb.append("[").append(i).append("]: ").append(vetor[i]).append("\n");
        }
        return sb.toString();
    }

}// class
