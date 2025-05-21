package ArvoreBinária;

public class ArvoreBinaria<T> {
    private No<T> raiz;

    public ArvoreBinaria () {
        this.raiz = null;
    }//construtor

    public void setRaiz (No<T> raiz) {
        this.raiz = raiz;
    }

    public No<T> getRaiz () {
        return raiz;
    }


    public String exibirPreOrdem () {
        return exibirPreOrdem(raiz);
    }


    private String exibirPreOrdem (No<T> noAtual) {
        if (noAtual == null) {
            return "<>";
        }

        return "<" + noAtual.getInfo() + exibirPreOrdem(noAtual.getEsquerda()) + exibirPreOrdem(noAtual.getDireita()) + ">";
    }


    public int altura () {
        return altura(raiz);
    }

    private int altura (No<T> noAtual) {
        if (noAtual == null) {
            return 0;
        }

        int alturaLadoEsquerdo = altura(noAtual.getEsquerda()); //conta a quantidade de nós dos lados esquerdos
        int alturaLadoDireito = altura(noAtual.getDireita()); //conta a quantidade de nós dos lados direitos
        int maiorLado = Math.max(alturaLadoEsquerdo, alturaLadoDireito); //verifica qual quantidade maior e retorna

        return 1 + maiorLado; //soma a primeira chamada (raiz) com o resto
    }


    public int contarTotalNos () {
        return contarTotalNos(raiz);
    }

    private int contarTotalNos (No<T> noAtual) {
        if (noAtual == null) {
            return 0;
        }

        return 1 + contarTotalNos(noAtual.getEsquerda()) + contarTotalNos(noAtual.getDireita());
    }

    

}//class
