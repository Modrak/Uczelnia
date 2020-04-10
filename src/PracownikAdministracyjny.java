
public class PracownikAdministracyjny  extends PracownikUczelni implements java.io.Serializable {

    int solvedCases;


    public PracownikAdministracyjny(String a, String b, int c, int d, int e, int f) {
        name=a;
        lastName=b;
        age=c;
        pesel=d;
        salary=e;
        solvedCases=f;
        System.out.println(name+lastName+age);
    }
    public void presentAdmin(){
        System.out.println("Imie:"+name+" Nazwisko: "+lastName+" Wiek: "+age+" Wypłata: "+salary);
    }

}

