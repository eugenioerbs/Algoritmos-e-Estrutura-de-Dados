package QuickSort;

public class MainTeste {
    public static void main(String[] args) {
        MetodoQuick classe = new MetodoQuick();

        int[] array = new int[5];

        array[0] = 2;
        array[1] = 1;
        array[2] = 3;
        array[3] = 5;
        array[4] = 4;
        classe.quickSort(array);

        System.out.println(classe.exibirVetor(array));
    }
}
