import javax.swing.JOptionPane;




public class ListDupla<T> {
    private NoListaDupla<T> primeiro;
    private NoListaDupla<T> ultimo;
     
    public ListDupla() {
        this.primeiro = null;
    }//construtor

    
    
    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }
    
    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);
        novo.setProximo(primeiro);
        if (primeiro != null) { //se a lista não estiver vazia | lista tem itens
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public void inserirFinal(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);
        if (primeiro == null) { //se lista vazia
            primeiro = novo;
            ultimo = novo;
        } else { //se lista tem nós
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
    }
    
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) { //enquanto o loop não chegar no final (null)
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null; //não encontrou
    }
    
    public void retirar (T valor) {
        NoListaDupla<T> atual = buscar(valor);
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "O valor não existe na lista");
            return;
        }
        if (atual.getAnterior() != null) {
            atual.getAnterior().setProximo(atual.getProximo());
        } else {
            primeiro = atual.getProximo();
        }
        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(atual.getAnterior());
        }
    }
    
    public void exibirOrdemInversa () {
        NoListaDupla<T> atual = primeiro;
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "O valor não existe na lista");
            return;
        }
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        while (atual != null) {
            JOptionPane.showMessageDialog(null, atual.getInfo() + " ");
            atual = atual.getAnterior();
        }
    }
    
    public void liberar () {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual = proximo;
        }
        primeiro = null;
    }
    
    public String toString () {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }
    

    public ListDupla<T> clonar() { //clona uma lista inserindo no final, dando a ordem certa para a clonagem.
        ListDupla<T> novaLista = new ListDupla<>();
        NoListaDupla<T> no = primeiro;
        
        while (no != null) { //enquanto o loop não chegar no final (null)
            novaLista.inserirFinal(no.getInfo());
            no = no.getProximo();
        }
    
        return novaLista;
    }
    
    
    
}//class