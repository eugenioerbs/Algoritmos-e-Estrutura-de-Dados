package ArvoreBinariaBusca;

public class MainTesteABB {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.inserirNo(10);
        arvore.inserirNo(20);
        arvore.inserirNo(4);
        arvore.inserirNo(15);
        

        //     10
        //    / \
        //  4    20
        //       /
        //     15

        System.out.println(arvore.buscarIterativo(15).getValor());

    }
}
