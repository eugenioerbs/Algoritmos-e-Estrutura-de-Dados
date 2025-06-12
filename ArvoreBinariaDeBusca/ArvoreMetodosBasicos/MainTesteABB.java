package ArvoreBinariaBusca;


public class MainTesteABB {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.inserirNo(50);
        arvore.inserirNo(40);
        arvore.inserirNo(70);
        arvore.inserirNo(75);
        arvore.inserirNo(71);
        arvore.inserirNo(76);
        arvore.inserirNo(60);
        arvore.remover(40);

        System.out.println(arvore.exibirPreOrdem());
    }
}
