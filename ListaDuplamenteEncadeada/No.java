package ex2Codes;

public class No {
    private String name;
    private No anterior;
    private No proximo;

    public No (String name) {
        this.name = name;
        this.anterior = null;
        this.proximo = null;
    }//constructor

    public void setName (String valor) {
        this.name = valor;
    }

    public String getName () {
        return name;
    }

    public void setAnterior (No value) {
        this.anterior = value;
    }

    public No getAnterior () {
        return anterior;
    }

    public void setProximo (No value) {
        this.proximo = value;
    }

    public No getProximo () {
        return proximo;
    }

}//class
