package TabelaDispersaoProf;

import java.time.LocalDate;

public class Aluno {
    private int registration;
    private String name;
    private LocalDate dateBirth;

    public Aluno (int registration, String name, LocalDate dateBirth) {
        this.registration = registration;
        this.name = name;
        this.dateBirth = dateBirth;
    }//construtor

    public void setRegistration (int registration) {
         this.registration = registration;
    }

    public int getRegistration () {
        return registration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public int getAg () { //for to get the age in int number
        return LocalDate.now().getYear() - dateBirth.getYear();
    }

}//class
