import javax.swing.JOptionPane;

public class Fila {
    private No primeiro;
    private No ultimo;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
    }// construtor

    public No getPrimeiro() {
        return primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }


    public void inserirCliente(int cadastro, int idade) {
        No novo = new No(cadastro, idade);

        if (isEmpty()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
    }


    public Boolean atenderPrioritarios() { // Retorna true só se atender um idoso.
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        No no = primeiro;

        while (no != null) {
            No proximo = no.getProximo();
            if (no.getIdade() > 60) {
                if (no == primeiro && no == ultimo) { //se tiver so um cliente, e for preferencial
                    primeiro = null;
                    ultimo = null;
                    return true;
                } else if (no == primeiro) { //se for o primeiro, mas tiver outros clientes
                    primeiro.getProximo().setAnterior(null);
                    primeiro = primeiro.getProximo();
                    return true;
                } else if (no == ultimo) { //se for o ultimo, mas tiver outros clientes
                    ultimo.getAnterior().setProximo(null);
                    ultimo = ultimo.getAnterior();
                    return true;
                }
            } else {
                no = proximo;
            }
        }
        return false;
    }

    public void atenderCliente() { //ok
        if (atenderPrioritarios() == true) {
            JOptionPane.showMessageDialog(null, "Idoso atendido na frente.");
            return;
        }

        No no = primeiro;

        if (no == primeiro && no == ultimo) {
            primeiro = null;
            ultimo = null;
            return;
        } else if (no == primeiro) {
            primeiro.getProximo().setAnterior(null);
            primeiro = primeiro.getProximo();
            return;
        } else if (no == ultimo) {
            ultimo.getAnterior().setProximo(null);
            ultimo = ultimo.getAnterior();
            return;
        }
    }


    public String peek() {
        StringBuilder sb = new StringBuilder();

        sb.append(primeiro.getCadastro()).append(" - ").append(primeiro.getIdade());

        return sb.toString();
    }

    public String exibir() {
        StringBuilder sb = new StringBuilder();

        No no = primeiro;

        while (no != null) {
            No proximo = no.getProximo();
            if (no.getProximo() != null) {
                sb.append(no.getCadastro()).append(", ").append(no.getIdade()).append(" - ");
            } else {
                sb.append(no.getCadastro()).append(", ").append(no.getIdade());
            }
            no = proximo;
        }
        return sb.toString();
    }

    
}// class
