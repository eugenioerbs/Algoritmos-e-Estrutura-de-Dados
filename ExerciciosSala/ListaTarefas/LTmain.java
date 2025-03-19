package LT;

import javax.swing.JOptionPane;

public class LTmain {
    public static void main(String[] args) {
        ListaTarefas<String> lista = new ListaTarefas<>();
        lista.inserir(1, "Limpar a casa", 1);
        lista.inserir(2, "Estudar", 2);
        lista.inserir(3, "Correr", 3);
        JOptionPane.showMessageDialog(null, lista.exibirTodos());
        JOptionPane.showMessageDialog(null, lista.buscarPeloId(2).getDescricao());
        lista.ordenarPrioridade();
        JOptionPane.showMessageDialog(null, lista.exibirTodos());

    }//main

}//class
