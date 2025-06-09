/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorHTML;

/**
 * Classe responsável por empilhar os elementos (tags);
 * 
 */
public class Pilha {
    private ElementoPilha topo;

    
    /**
     * Empilha
     * @param dado 
     */
    public void empilhar(String dado) {
        ElementoPilha novo = new ElementoPilha(dado);
        novo.setProximo(topo);
        topo = novo;
    }

    
    /**
     * Remove o elemento denominado topo da pilha.
     * @return 
     */
    public String desempilhar() {
        if (topo == null) {
            return null;
        }
        String topoRetornar = topo.getDado();

        topo = topo.getProximo();

        return topoRetornar;
    }

    
    /**
     * Retorna o topo da pilha.
     * @return
     */
    public String topo () {
        if (topo == null || topo.getDado() == null) {
            return null;
        }
        
        return topo.getDado();
    }
    
    
    /**
     * Retorna true se e pilha estiver vazia;
     * @return true se vazia, e false se não vazia
     */
    public boolean estaVazia () {
        return topo == null;
    }
    
    
    /**
     * Retorna um vetor do tipo String com todos os elementos (tags) presentes na pilha;
     * @return 
     */
    public String[] getElementosRestantes () {   
        int tam = 0;
        ElementoPilha atual = topo;
        while (atual != null) {            
            tam++;
            atual = atual.getProximo();
        }
        
        String[] res = new String[tam];
        atual = topo;
        int indice = 0;
        while (atual != null) {
            res[indice] = atual.getDado();
            indice++;
            atual= atual.getProximo();
        }
        return res;
    }
    
    
}//class

