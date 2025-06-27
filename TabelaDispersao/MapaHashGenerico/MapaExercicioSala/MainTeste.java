package TabelaDispersaoProf;

import java.time.LocalDate;

public class MainTeste {
    public static void main(String[] args) {

        Aluno lana = new Aluno(2005, "Lana DelRey", LocalDate.of(2005, 05, 19));
        Aluno leidi = new Aluno(2009, "Leidi DelRey", LocalDate.of(2009, 01, 28));
       
        MapaHash map = new MapaHash<>(11);

        map.insert(2005, lana);
        map.insert(2009, leidi);

        MapaHash newMap = new MapaHash<>(11);

        Aluno oi = new Aluno(2006, "Oi DelRey", LocalDate.of(2005, 05, 19));
        Aluno boi = new Aluno(2010, "Boi DelRey", LocalDate.of(2009, 01, 28));

        newMap.insert(2006, oi);
        newMap.insert(2010, boi);
        
    
        map.unirSemSobrescrever(newMap);

        System.out.println(map.showIt());
    }
}
