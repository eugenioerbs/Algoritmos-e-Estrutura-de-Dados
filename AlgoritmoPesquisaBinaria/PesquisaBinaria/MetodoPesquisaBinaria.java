package PesquisaBinaria;

public class MetodoPesquisaBinaria {

    public int buscaBinaria (int[] vetor, int valorProcurado) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) { 
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == valorProcurado) {
                return meio; 
            } else if (vetor[meio] < valorProcurado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // Valor não encontrado
    }

    
    public String exibirVetor(int[] vetor) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vetor.length; i++) {
            sb.append("[").append(i).append("]: ").append(vetor[i]).append("\n");
        }
        return sb.toString();
    }

}//class
