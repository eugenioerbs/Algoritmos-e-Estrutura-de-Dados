package BubleSort;

public class MainTeste {
    public static void main(String[] args) {
        MetodoBolha classe = new MetodoBolha();

        int [] array =  new int[5];

        array[0] = 2;
        array[1] = 1;
        array[2] = 3;
        array[3] = 5;
        array[4] = 4;
        classe.bubbleSortDescUmaTroca(array);;

        System.out.println(classe.exibirVetor(array));
    }
}
