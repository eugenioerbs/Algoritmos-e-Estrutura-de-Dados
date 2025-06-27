package TabelaDispersaoProf;

public class ListaEncadeada<T> {
    private No<T> first;
    private No<T> last;

    public ListaEncadeada () {
        this.first = null;
        this.last = null;
    }//constructor

    public void setFirst(No<T> first) {
        this.first = first;
    }

    public No<T> getFirst() {
        return first;
    }

    public void setLast(No<T> last) {
        this.last = last;
    }

    public No<T> getLast() {
        return last;
    }   

    //método fila encadeada
    public void insert (No no) {

        if (first == null) {
            first = no;
            last = no;
        } else {
            last.setNext(no);
            no.setPrevious(last);
            no.setNext(null);
            last = no;
        }
    }

    public boolean isEmpty () {
        return (first == null) && (last == null);
    }

    public void remover(int chave) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        if (chave < 0) {
            throw new RuntimeException("Dados não informados");
        }

        No noPercorrendo = first;
        boolean found = false;

        while (noPercorrendo != null && !found) {
            if (noPercorrendo.getKey() == chave) {
                remover(noPercorrendo);
                found = true;
            }
            noPercorrendo = noPercorrendo.getNext();
        }
    }

    private void remover(No no) {
        if (no == first && no == last) {
            first = null;
            last = null;
        } else if (no == first) {
            first = first.getNext();
            first.setPrevious(null);
        } else if (no == last) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            no.getPrevious().setNext(no.getNext());
            no.getNext().setPrevious(no.getPrevious());
        }
    }

    public No buscar(int chave) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        No noPercorrendo = first;

        while (noPercorrendo != null) {
            if (noPercorrendo.getKey() == chave) {
                return noPercorrendo;
            }
            noPercorrendo = noPercorrendo.getNext();
        }
        return null;
    }


}//class
