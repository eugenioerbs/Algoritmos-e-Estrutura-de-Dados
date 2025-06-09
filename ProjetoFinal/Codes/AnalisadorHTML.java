/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorHTML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Responsável por de fato abrir e ler o conteúdo do arquivo HTML;
 *
 */
public class AnalisadorHTML {

    private final String caminho;
    private final Pilha pilha;
    private final TagInfo[] tags;
    private int totalTags = 0;
    private static final String[] SINGLETON_TAGS = {"meta", "base", "br", "col", "command", "embed", "hr", "img", "input", "link", "param", "source", "!doctype"}; //tags que não precisam ser fechadas

    public AnalisadorHTML(String caminhoV) {
        this.caminho = caminhoV;
        this.pilha = new Pilha();
        this.tags = new TagInfo[100];
    }//construtor

    /**
     * Lê o arquivo informado no atributo (caminho); Enquanto ouver linhas
     * dentro do arquivo, imcrementa uma contagem de (linha), remove espaços e
     * pula linhas vazias; Extrai o conteúdo dentro dos simbolos (<..>) para
     * identificar a tag; Se for uma tag de auto fechamento (SINGLETON_TAGS)
     * adiciona na lista, mas ignora no empilhamento; E se for uma de abertura,
     * adiciona na pilha; E se encontrar uma tag de fechamento, verifica se o
     * topo é igual. Se for desempilha e continua o processo, se não - retorna
     * erro; Após arquivo todo lido, se ainda exixtirem tags na pilha, ou seja
     * (foram abertas e não foram fechadas) retorna erro - mostrando qual faltam
     * fechar; E se não sobrar nenhuma tag na pilha, ou seja (todas tags abertas
     * e fechadas) o HTML está bem formatado e retorna uma - mensagem amigavel;
     *
     * @return mensagem
     */
    public String analisar() {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            int numeroDaLinha = 0;

            while ((linha = leitor.readLine()) != null) {
                numeroDaLinha++;
                linha = linha.trim();  //tira os espaços

                if (linha.isEmpty()) {
                    continue;
                }

                // Encontrar tags
                while (linha.contains("<")) {
                    int inicio = linha.indexOf("<");
                    int fim = linha.indexOf(">", inicio);
                    if (fim == -1) {
                        break; // Tag malformada
                    }
                    String tagCompleta = linha.substring(inicio + 1, fim).trim();
                    linha = linha.substring(fim + 1);  // Continua o processamento da linha

                    if (tagCompleta.isEmpty()) {
                        continue;
                    }

                    boolean isFinal = tagCompleta.startsWith("/");
                    tagCompleta = tagCompleta.replaceAll("/", "").toLowerCase();

                    String[] partes = tagCompleta.split(" ");
                    if (partes.length == 0) {
                        continue;
                    }
                    String nomeTag = partes[0];

                    if (Arrays.asList(SINGLETON_TAGS).contains(nomeTag)) {
                        adicionarTag(nomeTag);
                        continue;
                    }

                    if (!isFinal) {
                        pilha.empilhar(nomeTag);
                        adicionarTag(nomeTag);
                    } else {
                        String topo = pilha.desempilhar();
                        if (topo == null) {
                            return "Erro na linha " + numeroDaLinha + ": tag de fechamento </" + nomeTag + "> não esperada.";
                        }
                        if (!topo.equals(nomeTag)) {
                            return "Erro na linha " + numeroDaLinha + ": esperava </" + topo + "> mas encontrou </" + nomeTag + ">";
                        }
                    }
                }
            }

            if (!pilha.estaVazia()) {
                StringBuilder sb = new StringBuilder("Erro: faltam tags finais para ");
                for (String tag : pilha.getElementosRestantes()) {
                    sb.append("</").append(tag).append("> ");
                }
                return sb.toString().trim();
            }

            return "O arquivo está bem formatado.";

        } catch (IOException e) {
            return "Erro ao abrir arquivo: " + e.getMessage();
        }
    }

    /**
     *
     * @param nome
     */
    private void adicionarTag(String nome) {
        for (int i = 0; i < totalTags; i++) {
            if (tags[i].getNome().equals(nome)) {
                tags[i].incrementar();
                return;
            }
        }
        tags[totalTags++] = new TagInfo(nome);
    }

    /**
     *
     * @return resultado
     */
    public TagInfo[] getTagsOrdenadas() {
        TagInfo[] resultado = new TagInfo[totalTags];
        System.arraycopy(tags, 0, resultado, 0, totalTags);

        // Ordenação manual por nome (Selection Sort)
        for (int i = 0; i < resultado.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < resultado.length; j++) {
                if (resultado[j].nome.compareTo(resultado[menor].nome) < 0) {
                    menor = j;
                }
            }
            if (menor != i) {
                TagInfo temp = resultado[i];
                resultado[i] = resultado[menor];
                resultado[menor] = temp;
            }
        }

        return resultado;
    }

}//class

