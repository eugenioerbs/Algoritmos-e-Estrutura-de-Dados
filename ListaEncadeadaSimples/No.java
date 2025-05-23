package ex1Codes;

public class No {
    private int numero;
    private No proximo;

    public No (int numero) {
        this.numero = numero;
        this.proximo = null;
    }//construtor

    
    public int getNumero () {
        return numero;
    }

    public void setNumero (int valor) {
        this.numero = valor;
    }

    public No getProximo () {
        return proximo;
    }

    public void setProximo (No no) {
        this.proximo = no;
    }


}//class
