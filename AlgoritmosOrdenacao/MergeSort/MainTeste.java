package MergeSort;

public class MainTeste {
    public static void main(String[] args) {
        MetodoMerge classe = new MetodoMerge();

        int [] array =  new int[5];

        array[0] = 2;
        array[1] = 1;
        array[2] = 3;
        array[3] = 5;
        array[4] = 4;
        classe.mergeSort(array);
        

        System.out.println(classe.exibirVetor(array));
    }
}
