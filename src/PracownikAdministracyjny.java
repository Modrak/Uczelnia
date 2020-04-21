
public class PracownikAdministracyjny  extends PracownikUczelni implements java.io.Serializable {

    int solvedCases;


    public PracownikAdministracyjny(String name, String lastName, int age, int pesel, int salary, int solvedCases) {
       super(name,lastName,age,pesel,salary);
       this.solvedCases=solvedCases;
    }
    public void presentAdmin(){
        System.out.println("Imie:"+name+" Nazwisko: "+lastName+" Wiek: "+age+" Wypłata: "+salary);
    }

}

