package ArvoreBinariaBusca;

public class NoABB {
    private int valor;
    private NoABB esquerda;
    private NoABB direita;

    public NoABB (int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }//cosstrutor


    public void setValor (int valor) {
        this.valor = valor;
    }

    public int getValor () {
        return valor;
    }
    
    public void setEsquerda(NoABB esquerda) {
        this.esquerda = esquerda;
    }

    public NoABB getEsquerda() {
        return esquerda;
    }

    public void setDireita(NoABB direita) {
        this.direita = direita;
    }

    public NoABB getDireita() {
        return direita;
    }
    

}//class
