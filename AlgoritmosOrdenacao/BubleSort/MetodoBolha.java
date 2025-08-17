package BubleSort;

public class MetodoBolha {

        public void bubleSort (int [] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }


    public void ordenarPorBolhaMelhorado (int[] vetor) {
        int n = vetor.length;
        boolean trocou;

        for (int i = n - 1; i >= 1; i--) {
            trocou = false;

            for (int j = 0; j < i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocou = true;
                }
            }

            if (!trocou) {
                return;
            }
        }
    }
////////
    public void bubbleSortDescUmaTroca(int[] vetor) {
    boolean trocou = true;

    while (trocou) {
        trocou = false;

        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] < vetor[i + 1]) {
                
                int temp = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = temp;
                trocou = true;
                break;
            }
        }
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
