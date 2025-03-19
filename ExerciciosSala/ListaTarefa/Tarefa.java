package LT;

public class Tarefa<T> {
    private int id;
    private String descricao;
    private int prioridade;
    private Tarefa<T> anterior;
    private Tarefa<T> proximo;

    public Tarefa(int id, String descricao, int prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.anterior = null;
        this.proximo = null;
    }//construtor

    public void setId(int id) {
        this.id = id;
    }

    public int getId () {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade () {
        return prioridade;
    }

    public void setAnterior(Tarefa<T> anterior) {
        this.anterior = anterior;
    }

    public Tarefa<T> getAnterior () {
        return anterior;
    }

    public void setProximo(Tarefa<T> proximo) {
        this.proximo = proximo;
    }

    public Tarefa<T> getProximo () {
        return proximo;
    }

}