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

    // Métodos Abaixo;
    // IsEmpty; inserir; exibirPreOrdem; RemoverNo; BuscarNó; contarNós;
    // estáBalanceada; éCheia; contarFolhas; getNivel; seguePadrãoBST;
    // contarNoQuePossuiDoisFilhos; contarNoComUmFilho; contarNosInternos;
    // getAltura; mostrarCaminho; menorValor; maiorValor; copiarÁrvore;
    // inverterArvore; somarÁrvore; somarAtéTalNo; mostrarCaminhoEntreNós;
    // alturaComFila; balancearArvore; pertence; buscarNóIterativo

    public boolean isEmpty() {
        return raiz == null;
    }

    public void inserirNo(int valor) {
        raiz = inserirNo(this.raiz, valor); // chamar o método inserir passando a raiz p private, depois transforma o
                                            // valor retornado No raiz, que vai ser a raiz novamente.

    }

    private NoABB inserirNo(NoABB noQuePercorre, int valor) { // começa com a raiz e vai percorrendo pra esq ou dir

        if (noQuePercorre == null) {
            return new NoABB(valor);
        }

        if (valor < noQuePercorre.getValor()) {
            noQuePercorre.setEsquerda(inserirNo(noQuePercorre.getEsquerda(), valor)); // se valor menor que o nó atual,
                                                                                      // tenta settar na esquerda, porém
                                                                                      // só será settado se o nó da
                                                                                      // esquerda for nullo, se não for,
                                                                                      // vai ser chamando e comparado
                                                                                      // mais uma vez, até encontrar um
                                                                                      // espaço livre.

        } else if (valor > noQuePercorre.getValor()) {
            noQuePercorre.setDireita(inserirNo(noQuePercorre.getDireita(), valor)); // se valor maior que o nó atual,
                                                                                    // tenta settar na direita, porém só
                                                                                    // será settado se o nó da direita
                                                                                    // for nullo, se não for, vai ser
                                                                                    // chamando e comparado mais uma
                                                                                    // vez, até encontrar um espaço
                                                                                    // livre.
        }

        return noQuePercorre; // quando o novo nó for settado, vai voltando as recursões e no final de tudo
                              // retorna a raiz novamentes;

    }

    public String exibirPreOrdem() {
        return exibirPreOrdem(raiz); // chama o método exibir passando a raiz
    }

    private String exibirPreOrdem(NoABB no) {
        if (no == null) { // se o nó atual que está percorrendo for null, retorna isso <>
            return "<>";
        }

        return "<" + no.getValor() + exibirPreOrdem(no.getEsquerda()) + exibirPreOrdem(no.getDireita()) + ">";
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private NoABB removerRecursivo(NoABB no, int valor) {
        if (no == null)
            return null;

        if (valor < no.getValor()) {
            no.setEsquerda(removerRecursivo(no.getEsquerda(), valor));

        } else if (valor > no.getValor()) {
            no.setDireita(removerRecursivo(no.getDireita(), valor));

        } else { // Encontrou o nó a ser removido

            if (no.getEsquerda() == null && no.getDireita() == null) { // Caso 1: nó sem filhos
                return null;

            } else if (no.getEsquerda() == null) { // Caso 2: só tem filho à direita
                return no.getDireita();

            } else if (no.getDireita() == null) { // ou só tem filho à esquerda
                return no.getEsquerda();

            } else { // Caso 3: dois filhos – usar o sucessor (menor valor da subárvore direita)
                NoABB sucessor = encontrarMenor(no.getDireita());
                no.setValor(sucessor.getValor());
                no.setDireita(removerRecursivo(no.getDireita(), sucessor.getValor()));
            }
        }

        return no;
    }

    public NoABB encontrarMenor(NoABB no) {
        // Vai até o menor valor (mais à esquerda possível)
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

    public NoABB buscarNo(int valor) {
        return buscarNo(raiz, valor);
    }

    private NoABB buscarNo(NoABB atual, int valor) {
        if (atual == null || atual.getValor() == valor) {
            return atual;
        }

        if (valor < atual.getValor()) {
            return buscarNo(atual.getEsquerda(), valor);
        } else {
            return buscarNo(atual.getDireita(), valor);
        }
    }

    public int alturaArvore() {
        return alturaArvore(this.raiz);
    }

    private int alturaArvore(NoABB atual) {
        if (atual == null) {
            return 0;
        }

        int alturaEsquerda = alturaArvore(atual.getEsquerda());
        int alturaDireita = alturaArvore(atual.getDireita());

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoABB atual) {
        if (atual == null) {
            return 0;
        }

        return 1 + contarNos(atual.getEsquerda()) + contarNos(atual.getDireita());
    }

    public boolean estaBalanceada() {
        return estaBalanceada(raiz) != -1;
    }

    private int estaBalanceada(NoABB atual) {
        if (atual == null) {
            return 0;
        }

        int alturaEsq = estaBalanceada(atual.getEsquerda());
        if (alturaEsq == -1) {
            return -1;
        }

        int alturaDireita = estaBalanceada(atual.getDireita());
        if (alturaDireita == -1) {
            return -1;
        }

        if (Math.abs(alturaEsq - alturaDireita) > 1) {
            return -1;
        }

        return 1 + Math.max(alturaEsq, alturaDireita);
    }

    public boolean estaCheia() {
        return estaCheia(raiz);
    }

    private boolean estaCheia(NoABB atual) {
        if (atual == null) {
            return true;
        }

        if ((atual.getEsquerda() == null && atual.getDireita() != null)
                || (atual.getEsquerda() != null && atual.getDireita() == null)) {
            return false;
        }

        return estaCheia(atual.getEsquerda()) && estaCheia(atual.getDireita());
    }

    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(NoABB atual) {
        if (atual == null)
            return 0;
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 1;
        }
        return contarFolhas(atual.getEsquerda()) + contarFolhas(atual.getDireita());
    }

    public int getNivel(int valor) {
        return getNivel(raiz, valor, 0);
    }

    private int getNivel(NoABB atual, int valor, int nivel) {
        if (atual == null)
            return -1; // nó não encontrado
        if (atual.getValor() == valor)
            return nivel;
        if (valor < atual.getValor()) {
            return getNivel(atual.getEsquerda(), valor, nivel + 1);
        } else {
            return getNivel(atual.getDireita(), valor, nivel + 1);
        }
    }

    public boolean seguePadraoBst() {
        return seguePadraoBst(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE); // Como o método inicia com a raiz e ela não
                                                                           // possui restrição, utilizamos o MIM e o
                                                                           // MAX;
    }

    private boolean seguePadraoBst(NoABB atual, int min, int max) {
        if (atual == null)
            return true;
        if (atual.getValor() <= min || atual.getValor() >= max)
            return false;

        return seguePadraoBst(atual.getEsquerda(), min, atual.getValor())
                && seguePadraoBst(atual.getDireita(), atual.getValor(), max);
    }

    public int contarNoComDoisFilhos() {
        return contarNoComDoisFilhos(raiz);
    }

    private int contarNoComDoisFilhos(NoABB atual) {
        if (atual == null)
            return 0;

        int count = contarNoComDoisFilhos(atual.getEsquerda()) + contarNoComDoisFilhos(atual.getDireita());

        if (atual.getEsquerda() != null && atual.getDireita() != null)
            count++;

        return count;
    }

    public int contarNoComUmFilho() {
        return contarNoComUmFilho(raiz);
    }

    private int contarNoComUmFilho(NoABB atual) {
        if (atual == null)
            return 0;

        int count = contarNoComUmFilho(atual.getEsquerda()) + contarNoComUmFilho(atual.getDireita());

        if ((atual.getEsquerda() != null && atual.getDireita() == null)
                || (atual.getEsquerda() == null && atual.getDireita() != null))
            count++;

        return count;
    }

    public int contarNosInternos() {
        return contarNosInternos(raiz);
    }

    private int contarNosInternos(NoABB atual) {
        if (atual == null || (atual.getEsquerda() == null && atual.getDireita() == null))
            return 0;

        return 1 + contarNosInternos(atual.getEsquerda()) + contarNosInternos(atual.getDireita());
    }

    public int getAltura() {
        return getAltura(raiz);
    }

    private int getAltura(NoABB atual) {
        if (atual == null)
            return -1;
        return 1 + Math.max(getAltura(atual.getEsquerda()), getAltura(atual.getDireita()));
    }

    public void limpar() {
        raiz = null;
    }

    public String mostrarCaminho(int valor) {
        StringBuilder caminho = new StringBuilder();
        boolean encontrado = mostrarCaminho(raiz, valor, caminho);

        if (encontrado) {
            return caminho.toString().trim();
        } else {
            return "Valor não encontrado.";
        }
    }

    private boolean mostrarCaminho(NoABB atual, int valor, StringBuilder caminho) {
        if (atual == null)
            return false;

        caminho.append(atual.getValor()).append(" "); // acumula valor no caminho

        if (atual.getValor() == valor)
            return true;

        if (valor < atual.getValor()) {
            return mostrarCaminho(atual.getEsquerda(), valor, caminho);
        } else {
            return mostrarCaminho(atual.getDireita(), valor, caminho);
        }
    }

    public int menorValor() {
        if (raiz == null)
            throw new RuntimeException("BST vazia!");

        NoABB atual = raiz;

        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }

        return atual.getValor();
    }

    public int maiorValor() {
        if (raiz == null)
            throw new RuntimeException("BST vazia!");

        NoABB atual = raiz;

        while (atual.getDireita() != null) {
            atual = atual.getDireita();
        }

        return atual.getValor();
    }

    public ArvoreBinariaBusca copiarArvore() {
        ArvoreBinariaBusca nova = new ArvoreBinariaBusca();
        nova.setRaiz(copiarArvore(raiz));
        return nova;
    }

    private NoABB copiarArvore(NoABB atual) {
        if (atual == null)
            return null;
        NoABB novo = new NoABB(atual.getValor());
        novo.setEsquerda(copiarArvore(atual.getEsquerda()));
        novo.setDireita(copiarArvore(atual.getDireita()));
        return novo;
    }

    public void inverterArvore() {
        inverter(raiz);
    }

    private void inverter(NoABB atual) {
        if (atual == null)
            return;
        NoABB tempo = atual.getEsquerda();
        atual.setEsquerda(atual.getDireita());
        atual.setDireita(tempo);
        inverter(atual.getEsquerda());
        inverter(atual.getDireita());
    }


    public int somarArvore() {
        return somarArvore(raiz);
    }

    private int somarArvore (NoABB atual) {
        if (atual == null) return 0;
        return atual.getValor() + somarArvore(atual.getEsquerda()) + somarArvore(atual.getDireita());
    }


    public int somarAteNo(int valor) {
        return somarAteNo(this.raiz, valor);
    }

    private int somarAteNo (NoABB atual, int valor) {
        if (atual == null) throw new RuntimeException("Nó não encontrado");

        if (valor == atual.getValor()) return atual.getValor();

        if (valor < atual.getValor()) return atual.getValor() + somarAteNo(atual.getEsquerda(), valor);
        else return atual.getValor() + somarAteNo(atual.getDireita(), valor);
    }


    public String caminhoEntreNos(int a, int b) {
    NoABB[] caminhoA = new NoABB[100];
    NoABB[] caminhoB = new NoABB[100];
    int tamA = encontrarCaminho(raiz, a, caminhoA);
    int tamB = encontrarCaminho(raiz, b, caminhoB);

    int i = 0;
    while (i < tamA && i < tamB && caminhoA[i].getValor() == caminhoB[i].getValor()) {
        i++;
    }

    StringBuilder sb = new StringBuilder();

    // Do nó A até o ancestral comum (em ordem reversa)
    for (int j = tamA - 1; j >= i; j--) {
        sb.append(caminhoA[j].getValor()).append(" -> ");
    }

    // Do ancestral comum até o nó B (em ordem normal)
    for (int j = i - 1; j < tamB; j++) {
        sb.append(caminhoB[j].getValor());
        if (j < tamB - 1) sb.append(" -> ");
    }

    return sb.toString();
}

private int encontrarCaminho(NoABB no, int valor, NoABB[] caminho) {
    int i = 0;
    while (no != null) {
        caminho[i++] = no;
        if (valor == no.getValor()) break;
        else if (valor < no.getValor()) no = no.getEsquerda();
        else no = no.getDireita();
    }
    return i;
}


public int alturaComFilaManual() {
    if (raiz == null) return -1;

    NoABB[] fila = new NoABB[100];
    int inicio = 0, fim = 0;

    fila[fim++] = raiz;
    int altura = -1;

    while (inicio < fim) {
        int tamanhoNivel = fim - inicio;

        for (int i = 0; i < tamanhoNivel; i++) {
            NoABB atual = fila[inicio++];

            if (atual.getEsquerda() != null) fila[fim++] = atual.getEsquerda();
            if (atual.getDireita() != null) fila[fim++] = atual.getDireita();
        }

        altura++;
    }

    return altura;
}


private static class Contador {
    int valor = 0;
}

public void balancear() {
    int total = contarNos();
    int[] elementos = new int[total];

    Contador contador = new Contador(); // índice de preenchimento
    preencherEmOrdem(raiz, elementos, contador);

    raiz = construirArvoreBalanceada(elementos, 0, total - 1); // nova raiz balanceada
}


private void preencherEmOrdem(NoABB no, int[] vetor, Contador contador) {
    if (no == null) return;

    preencherEmOrdem(no.getEsquerda(), vetor, contador);
    vetor[contador.valor++] = no.getValor();
    preencherEmOrdem(no.getDireita(), vetor, contador);
}

private NoABB construirArvoreBalanceada(int[] vetor, int inicio, int fim) {
    if (inicio > fim) return null;

    int meio = (inicio + fim) / 2;
    NoABB novo = new NoABB(vetor[meio]);

    novo.setEsquerda(construirArvoreBalanceada(vetor, inicio, meio - 1));
    novo.setDireita(construirArvoreBalanceada(vetor, meio + 1, fim));

    return novo;
}

//retorna um true
public boolean pertenceBolean (int valor) {
    return pertenceBolean(raiz, valor);
}

private boolean pertenceBolean (NoABB atual, int valor) {
    if (atual == null) return false;
    if (atual.getValor() == valor) return true;

    if (valor < atual.getValor()) {
        return pertenceBolean(atual.getEsquerda(), valor);
    } else {
        return pertenceBolean(atual.getDireita(), valor);
    }
}

//retorna o no
public NoABB pertenceNo (int valor) {
    return pertenceNo(raiz, valor);
}

private NoABB pertenceNo (NoABB atual, int valor) {
    if (atual == null) return null;
    if (atual.getValor() == valor) return atual;

    if (valor < atual.getValor()) {
        return pertenceNo(atual.getEsquerda(), valor);
    } else {
        return pertenceNo(atual.getDireita(), valor);
    }
}

public NoABB buscarIterativo(int valor) {
    NoABB no = raiz;

    while (no != null && no.getValor() != valor) {
        if (valor < no.getValor()) {
            no = no.getEsquerda();
        } else {
            no = no.getDireita();
        }
    }

    return no; // Retorna o nó encontrado ou null se não achou
}
}// class
