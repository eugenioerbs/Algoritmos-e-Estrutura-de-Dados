import javax.swing.JOptionPane;

public class MainTest {
    public static void main(String[] args) {
        Fila fila = new Fila();
        
        fila.inserirCliente(2005, 19);
        fila.inserirCliente(2009, 16);
        fila.inserirCliente(2006, 18);

        fila.atenderCliente();
        JOptionPane.showMessageDialog(null, fila.exibir());
    }
}//class
