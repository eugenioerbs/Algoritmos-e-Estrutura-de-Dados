/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorHTML;

/**
 *
 * @author Usuario
 */
public class ElementoPilha {
    private String dado;
    private ElementoPilha proximo;
    
    public ElementoPilha(String dado) {
        this.dado = dado;
        
    }//construtor
    
    public void setProximo (ElementoPilha proximoV) {
        this.proximo = proximoV;
    }
    
    public ElementoPilha getProximo () {
        return proximo;
    }
    
    public void setDado (String dadoV) {
        this.dado = dadoV;
    }
    
    public String getDado () {
        return dado;
    }
    
}//class


