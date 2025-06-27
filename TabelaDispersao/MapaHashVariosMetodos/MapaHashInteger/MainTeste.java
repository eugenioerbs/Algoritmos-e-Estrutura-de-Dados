package TabelaDispersao;

public class MainTeste {
    public static void main(String[] args) {
        HashMap mapa = new HashMap(11);

        mapa.inserir(2005, "Eugenio Victor Erbs");
        mapa.inserir(2009, "Luiza Erbs");
        mapa.redimencionar();

        System.out.println(mapa.fatorCarga());

    }
}
