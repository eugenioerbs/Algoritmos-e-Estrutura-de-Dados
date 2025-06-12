package ArvoreBinariaBusca;

public class ArvoreBinariaBusca {
    private NoABB raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }// construtor


    public void setRaiz(NoABB raiz) {
        this.raiz = raiz;
    }

    public NoABB getRaiz() {
        return raiz;
    }

    //Métodos Abaixo;
    //IsEmpty; inserir; exibirPreOrdem; Remover.


    public boolean isEmpty() {
        return raiz == null;
    }

    public void inserirNo(int valor) {
        raiz = inserirNo(this.raiz, valor); //chamar o método inserir passando a raiz p private, depois transforma o valor retornado No raiz, que vai ser a raiz novamente.

    }

    private NoABB inserirNo(NoABB noQuePercorre, int valor) { //começa com a raiz e vai percorrendo pra esq ou dir

        if (noQuePercorre == null) {
            return new NoABB(valor);
        }

        if (valor < noQuePercorre.getValor()) { 
            noQuePercorre.setEsquerda(inserirNo(noQuePercorre.getEsquerda(), valor));  //se valor menor que o nó atual, tenta settar na esquerda, porém só será settado se o nó da esquerda for nullo, se não for, vai ser chamando e comparado mais uma vez, até encontrar um espaço livre.

        } else if (valor > noQuePercorre.getValor()) {
            noQuePercorre.setDireita(inserirNo(noQuePercorre.getDireita(), valor)); //se valor maior que o nó atual, tenta settar na direita, porém só será settado se o nó da direita for nullo, se não for, vai ser chamando e comparado mais uma vez, até encontrar um espaço livre.
        }

        return noQuePercorre; //quando o novo nó for settado, vai voltando as recursões e no final de tudo retorna a raiz novamentes;

    }


    public String exibirPreOrdem () {
        return exibirPreOrdem(raiz);  //chama o método exibir passando a raiz
    }


    private String exibirPreOrdem(NoABB no) {
        if (no == null) { //se o nó atual que está percorrendo for null, retorna isso <>
            return "<>";
        }

        return "<" + no.getValor() + exibirPreOrdem(no.getEsquerda()) + exibirPreOrdem(no.getDireita()) + ">";
    }


    public void remover(int valor) { //40
        raiz = removerRecursivo(raiz, valor);
    }


    private NoABB removerRecursivo(NoABB no, int valor) { //valor 40
        if (no == null) return null;

        if (valor < no.getValor()) { 
            no.setEsquerda(removerRecursivo(no.getEsquerda(), valor));
        
        } else if (valor > no.getValor()) {  
            no.setDireita(removerRecursivo(no.getDireita(), valor));

        } else {  // Encontrou o nó a ser removido
            
            if (no.getEsquerda() == null && no.getDireita() == null) {  // Caso 1: nó sem filhos
                return null;

            } else if (no.getEsquerda() == null) {  // Caso 2: só tem filho à direita               
                return no.getDireita();

            } else if (no.getDireita() == null) {  // ou só tem filho à esquerda
                return no.getEsquerda();

            } else {  // Caso 3: dois filhos – usar o sucessor (menor valor da subárvore direita)                
                NoABB sucessor = encontrarMenor(no.getDireita());
                no.setValor(sucessor.getValor());
                no.setDireita(removerRecursivo(no.getDireita(), sucessor.getValor()));
            }
        }

        return no;
    }

    private NoABB encontrarMenor(NoABB no) { 
        // Vai até o menor valor (mais à esquerda possível)
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no; 
    }


}// class
