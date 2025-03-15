public class No<T> {
    private T info;
    private No<T> anterior;
    private No<T> proximo;

    public No (T info) {
        this.info = info;
        this.anterior = null;
        this.proximo = null;

    }//construtor

    public T getInfo () {
        return info;
    }

    public void setInfo (T valorParaOInfo) {
        this.info = valorParaOInfo;
    }

    public No<T> getAnterior () {
        return anterior;
    }
    
    public void setAnterior (No<T> anteriorV) {
        this.anterior = anteriorV;
    }

    public No<T> getProximo () {
        return proximo;
    }
    
    public void setProximo (No<T> proximoV) {
        this.proximo = proximoV;
    }


}//class