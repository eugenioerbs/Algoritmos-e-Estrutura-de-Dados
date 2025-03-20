/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;

/**
 *
 * @author Usuario
 */
public class Aluno <T> {
    private String nome;
    private int cadastro;
    private Aluno<T> anterior;
    private Aluno<T> proximo;
    
    public Aluno (String nome, int cadastro) {
        this.nome = nome;
        this.cadastro = cadastro;
        this.anterior = null;
        this.proximo = null;
    }

    
    public String getNome() {
        return nome;
    }

    public int getCadastro() {
        return cadastro;
    }

    public Aluno<T> getAnterior() {
        return anterior;
    }

    public Aluno<T> getProximo() {
        return proximo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public void setAnterior(Aluno<T> anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Aluno<T> proximo) {
        this.proximo = proximo;
    }
    
    
}
