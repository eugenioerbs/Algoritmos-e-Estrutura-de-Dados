package MergeSort;

public class MetodoMerge {

    public void mergeSort (int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            // Chamada recursiva para as duas metades
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);

            // Mescla as duas metades ordenadas
            intercalar(array, inicio, meio, fim);
        }
    }

    // Método que faz a intercalação (merge) dos dois subarrays
    private void intercalar(int[] array, int inicio, int meio, int fim) {
        int tamanho1 = meio - inicio + 1;
        int tamanho2 = fim - meio;

        // Arrays temporários
        int[] esquerda = new int[tamanho1];
        int[] direita = new int[tamanho2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < tamanho1; i++) {
            esquerda[i] = array[inicio + i];
        }
        for (int j = 0; j < tamanho2; j++) {
            direita[j] = array[meio + 1 + j];
        }

        // Índices para iterar pelos arrays temporários
        int i = 0, j = 0, k = inicio;

        // Combina os arrays esquerda e direita em ordem
        while (i < tamanho1 && j < tamanho2) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes, se houver
        while (i < tamanho1) {
            array[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < tamanho2) {
            array[k] = direita[j];
            j++;
            k++;
        }
    }

    public String exibirVetor (int [] vetor) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vetor.length; i++) {
            sb.append("[").append(i).append("]: ").append(vetor[i]).append("\n");
        }
        return sb.toString();
    }
    
}//class
