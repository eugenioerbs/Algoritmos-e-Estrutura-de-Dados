package ex2Codes;

import javax.swing.JOptionPane;

public class MainTest {
    public static void main(String[] args) {
        
        ListaDuplaEncadeada lista1 = new ListaDuplaEncadeada();
        lista1.inserir("Davi");
        lista1.inserir("Bruna");
        lista1.inserir("Angela");
        lista1.inserir("Carlos");
        lista1.inserir("Angela");

        lista1.removerNomeThanStartWith("A");
        JOptionPane.showMessageDialog(null, lista1.exibirListaDoIncio());



    }
}//class
