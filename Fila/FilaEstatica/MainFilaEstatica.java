package Fila;

import javax.swing.JOptionPane;

public class MainFilaEstatica {
    public static void main(String[] args) {
        FilaEstatica fila = new FilaEstatica(3);

        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.desenfileirar();

        JOptionPane.showMessageDialog(null, fila.mostrarFila());

    }// psvm
}// class
