/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorHTML;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ClasseTelaPrincipal extends javax.swing.JFrame {

    private final JTextField campoArquivo;    //Botões/elementos sendo criados na memória
    private final JButton botaoAnalisar;
    private final JTextArea areaResultado;
    private final JTable tabelaTags;

    public ClasseTelaPrincipal () {
        super("Analizador HTML");                 //nomeando a janela vey
                                          //difinindo o tamanho da janela para minimo
        setLocationRelativeTo(null);               //centralizar tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //quando fechar janela, encerrar tudo
        setLayout(new BorderLayout());            //janela vai usar "ele", que divide a tela em 5 áreas (norte, sul, direito, esquerdo, centro)

        //Norte (campo de arquivo + botão)
        JPanel painelTopo = new JPanel();
        campoArquivo = new JTextField(30);
        botaoAnalisar = new JButton("Analisar");
        painelTopo.add(new JLabel("Arquivo: "));
        painelTopo.add(campoArquivo);
        painelTopo.add(botaoAnalisar);
        add(painelTopo, BorderLayout.NORTH);

        //Centro (Área de texto com resultado)
        areaResultado = new JTextArea(5, 40);
        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        //Sul (Tabela de tags)
        tabelaTags = new JTable(new DefaultTableModel(new Object[]{"Tag", "Número de ocorrencias"}, 0));
        add(new JScrollPane(tabelaTags), BorderLayout.SOUTH);

        botaoAnalisar.addActionListener(e -> analisarArquivo());

    } //construtor

    private void analisarArquivo() { //method 1
        String caminho = campoArquivo.getText();
        AnalisadorHTML analisador = new AnalisadorHTML(caminho);
        String resultado = analisador.analisar();

        areaResultado.setText(resultado);

        //atualiza a tabela
        DefaultTableModel modelo = (DefaultTableModel) tabelaTags.getModel();   //pega o modelo da "tabelaTags" e converte para "DefaultTableModel"
        modelo.setRowCount(0);   //limpa tabela e remove todas as linha anteriores
        TagInfo[] tags = analisador.getTagsOrdenadas();   //retorna o array de objetos ordenados (tags encontradas)
        for (TagInfo a : tags) {   //percorre todas as tags do vetor
            modelo.addRow(new Object[]{a.nome, a.contador});
        }
    }//method 1

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new ClasseTelaPrincipal().setVisible(true);
        });
    }
}