/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes;

/**
 *
 * @author Usuario
 */
public class Turma<T> {

    private int tamanho;
    private Aluno<T> primeiro;
    private Aluno<T> ultimo;

    public int getTamanho() {
        return tamanho;
    }

    public void inserirInicio(String nome, int cadastro) {
        Aluno<T> novo = new Aluno<>(nome, cadastro);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;

        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }
        primeiro.setAnterior(null);
        tamanho++;
    }

    public void inserirFinal(String nome, int cadastro) {
        Aluno<T> novo = new Aluno<>(nome, cadastro);

        if (primeiro == null) {
            ultimo = novo;
            primeiro = novo;
        } else {
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        ultimo.setProximo(null);
    }

    public void removerElemento(int cadastro) {
        Aluno<T> aluno = primeiro;

        while (aluno != null) {

            if (aluno.getCadastro() == cadastro) {
                if (aluno == primeiro) {
                    primeiro = aluno.getProximo();

                    if (primeiro != null) {
                        primeiro.setAnterior(null);
                    } else {
                        ultimo = null;
                    }
                    return;
                } else if (aluno.getProximo() == null) {
                    ultimo = aluno.getAnterior();
                    if (ultimo != null) {
                        ultimo.setProximo(null);
                    } else {
                        primeiro = null;
                    }
                    return;
                } else {
                    aluno.getAnterior().setProximo(aluno.getProximo());
                    aluno.getProximo().setAnterior(aluno.getAnterior());
                    return;
                }
            }
            aluno = aluno.getProximo();
        }
    }

    public Aluno<T> buscar(int cadastro) {
        Aluno<T> aluno = primeiro;

        while (aluno != null) {
            if (aluno.getCadastro() == cadastro) {
                return aluno;
            } else {
                aluno = aluno.getProximo();
            }
        }
        return null;
    }

    public void trocar(Aluno<T> a, Aluno<T> b) {
        if (a == b || a == null || b == null) {
            return; // Se forem iguais ou nulos, não troca
        }

        Aluno<T> antesA = a.getAnterior();
        Aluno<T> depoisA = a.getProximo();
        Aluno<T> antesB = b.getAnterior();
        Aluno<T> depoisB = b.getProximo();

        // Se A e B forem vizinhos, tratamos diferente para evitar erros
        if (a.getProximo() == b) {
            a.setProximo(depoisB);
            a.setAnterior(b);
            b.setProximo(a);
            b.setAnterior(antesA);
        } else if (b.getProximo() == a) {
            b.setProximo(depoisA);
            b.setAnterior(a);
            a.setProximo(b);
            a.setAnterior(antesB);

        } else { // Caso geral (A e B não são vizinhos)
            if (antesA != null) {
                antesA.setProximo(b);
            }
            if (depoisA != null) {
                depoisA.setAnterior(b);
            }
            if (antesB != null) {
                antesB.setProximo(a);
            }
            if (depoisB != null) {
                depoisB.setAnterior(a);
            }

            b.setProximo(depoisA);
            b.setAnterior(antesA);
            a.setProximo(depoisB);
            a.setAnterior(antesB);
        }

        // Atualiza a cabeça e cauda se necessário
        if (primeiro == a) {
            primeiro = b;
        } else if (primeiro == b) {
            primeiro = a;
        }

        if (ultimo == a) {
            ultimo = b;
        } else if (ultimo == b) {
            ultimo = a;
        }
    }

    public void inverter() {
        Aluno<T> atual = primeiro;
        Aluno<T> temp = null;

        // Percorre a lista e inverte os ponteiros
        while (atual != null) {
            temp = atual.getAnterior();
            atual.setAnterior(atual.getProximo());
            atual.setProximo(temp);
            atual = atual.getAnterior(); // Move para o próximo (que agora é o anterior)
        }

        // Ajusta o primeiro e o último corretamente
        if (temp != null) {
            primeiro = temp.getProximo(); // ✅ Novo primeiro elemento
            ultimo = temp; // ✅ Novo último elemento
        }
    }

}//class

