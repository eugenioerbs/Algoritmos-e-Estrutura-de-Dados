package Fila;

import javax.swing.JOptionPane;

public class MainFila {
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<Integer>();
        fila.inserirFinal(10);
        fila.inserirFinal(20);
        fila.inserirFinal(30);

        JOptionPane.showMessageDialog(null, fila.exibirInversamente());
        JOptionPane.showMessageDialog(null, fila.exibirCerto());
        JOptionPane.showMessageDialog(null, fila.removerERetornar().getInfo());
        JOptionPane.showMessageDialog(null, fila.exibirCerto());
        JOptionPane.showMessageDialog(null, fila.retornarInicio().getInfo());
        

    }//psvm
}//class
