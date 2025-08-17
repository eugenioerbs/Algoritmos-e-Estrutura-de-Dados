package PesquisaBinaria;


public class MainTeste {
    public static void main(String[] args) {
       MetodoPesquisaBinaria classe = new MetodoPesquisaBinaria();

        int[] array = new int[5];

        array[0] = 2;
        array[1] = 1;
        array[2] = 3;
        array[3] = 5;
        array[4] = 4;
        

        System.out.println(classe.buscaBinaria(array, 2)); 
    }//
}//class
