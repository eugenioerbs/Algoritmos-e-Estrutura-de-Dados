package TabelaDispersaoProf;

public class No<T> {    
    private int key;
    private T info;
    private No<T> previous;
    private No<T> next;
    
    public No (int key, T info) {
        this.key = key;
        this.info = info;
        this.previous = null;
        this.next = null;
    }//costructor
    
    public void setKey (int key) {
        this.key = key;
    }

    public int getKey () {
        return key;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setPrevious(No<T> previous) {
        this.previous = previous;
    }

    public No<T> getPrevious() {
        return previous;
    }

    public void setNext(No<T> next) {
        this.next = next;
    }

    public No<T> getNext() {
        return next;
    }


}//class
