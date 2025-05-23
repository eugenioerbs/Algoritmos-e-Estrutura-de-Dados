public class No {
    private int cadastro;
    private int idade;
    private No anterior;
    private No proximo;

    public No (int cadastro, int idade) {
        this.cadastro = cadastro;
        this.idade = idade;
        this.anterior = null;
        this.proximo = null;
    }//construtor


    public void setCadastro (int valor) {
        this.cadastro = valor;
    }

    public void setIdade (int valor) {
        this.idade = valor;
    }

    public int getCadastro () {
        return cadastro;
    }

    public int getIdade () {
        return idade;
    }

    public No getAnterior () {
        return anterior;
    }

    public No getProximo () {
        return proximo;
    }

    public void setAnterior (No valor) {
        this.anterior = valor;
    }

    public void setProximo (No valor) {
        this.proximo = valor;
    }

    
}//class
