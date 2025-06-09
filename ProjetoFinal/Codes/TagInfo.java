/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorHTML;

/**
 * Classe responsável por armazenar informações sobre as tags;
 * Qual nome dela;
 * Quantas vezes ela aparece.
 * 
 */
public class TagInfo {
    public String nome;
    public int contador;

    public TagInfo(String nomeV) {
        this.nome = nomeV;
        this.contador = 1;

    }//construtor

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Este método incrementa a cada repetição da tag encontrada.
     * 
     */
    public void incrementar() {
        contador++;
    }

}//class

