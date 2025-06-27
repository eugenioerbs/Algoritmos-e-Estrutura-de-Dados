package TabelaDispersao;

public class No {
    private int chave;
    private String name;
    private No anterior;
    private No proximo;

    public No (int chave, String name) {
        this.chave = chave;
        this.name = name;
        this.anterior = null;
        this.proximo = null;
    }//construtor

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return chave;
    }


    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getAnterior() {
        return anterior;
    }


    public void setProximo(No proximo) {
        this.proximo = proximo;
    }


    public No getProximo() {
        return proximo;
    }

    
}//class
