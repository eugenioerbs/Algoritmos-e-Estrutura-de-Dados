    package LT;

    import javax.swing.JOptionPane;

    public class ListaTarefas<T> {
        private Tarefa<T> primeiro;
        private int tamanho;


        public void inserir (int id, String descricao, int prioridade) {
            Tarefa<T> novaTarefa = new Tarefa<>(id, descricao, prioridade);

            if (primeiro == null) {
                primeiro = novaTarefa;
                JOptionPane.showMessageDialog(null, "Tarefa adicionada na lista!");
                tamanho++;
                return;
            } else {
                novaTarefa.setProximo(primeiro);
                primeiro.setAnterior(novaTarefa);
                primeiro = novaTarefa;
                novaTarefa.setAnterior(null);
                JOptionPane.showMessageDialog(null, "Tarefa adicionada na lista!");
                tamanho++;
                return;
            }
        }


        public void remover (int id) {
            Tarefa<T> tarefaDesejada = primeiro;
            
            while (tarefaDesejada != null) {
            

                if (tarefaDesejada.getId() == id) {

                    if (tarefaDesejada.getProximo() != null && tarefaDesejada.getAnterior() != null) { //meio
                        tarefaDesejada.getProximo().setAnterior(tarefaDesejada.getProximo());
                        tarefaDesejada.getAnterior().setProximo(tarefaDesejada.getProximo());
                        return;

                    } else if (tarefaDesejada == primeiro){ //primeiro
                        primeiro = primeiro.getProximo();
                        if (primeiro != null) {
                            primeiro.setAnterior(null);
                        }
                        
                    } else if (tarefaDesejada.getProximo() == null) { //final
                        tarefaDesejada.getAnterior().setProximo(null);
                        
                    }
                    tamanho--;
                    JOptionPane.showMessageDialog(null, "Tarefa removida!");
                    return;
                } 
                tarefaDesejada = tarefaDesejada.getProximo();
            }
        }


        public StringBuilder exibirTodos () {
            StringBuilder sb = new StringBuilder();

            Tarefa<T> tarefa = primeiro;

            while (tarefa != null) {
            sb.append("( ID " + tarefa.getId() + ": " + tarefa.getDescricao() + " - Prioridade: " + tarefa.getPrioridade() + " )\n" );
                tarefa = tarefa.getProximo();
            }

            return sb;
        }


        public Tarefa<T> buscarPeloId (int id) {
            Tarefa<T> no = primeiro;

            while (no != null) {
                if (no.getId() == id) {
                    return no;
                } else {
                    no = no.getProximo();
                }
            }
            return null;
        }


        public void ordenarPrioridade() {
            if (primeiro == null || primeiro.getProximo() == null) {
                JOptionPane.showMessageDialog(null, "Lista já ordenada ou sem elementos");
                return;
            }
        
            boolean trocou;
            do {
                trocou = false;
                Tarefa<T> atual = primeiro;
                Tarefa<T> anterior = null;
        
                while (atual.getProximo() != null) {
                    Tarefa<T> proximo = atual.getProximo();
        
                    if (atual.getPrioridade() > proximo.getPrioridade()) {
                        // Ajustando as referências para trocar os nós
                        if (anterior != null) {
                            anterior.setProximo(proximo);
                        } else {
                            primeiro = proximo;
                        }
        
                        atual.setProximo(proximo.getProximo());
                        proximo.setProximo(atual);
        
                        // Atualizar anterior para apontar corretamente
                        anterior = proximo;
        
                        trocou = true;
                    } else {
                        // Avançar para o próximo nó se não houve troca
                        anterior = atual;
                        atual = atual.getProximo();
                    }
                }
            } while (trocou);
        }
        


    }//class