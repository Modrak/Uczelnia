import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class PracownikAdministracyjny  extends PracownikUczelni implements java.io.Serializable {

    int solvedCases;


    public PracownikAdministracyjny(String a, String b, int c, int d, int e) {
        name=a;
        lastName=b;
        age=c;
        pesel=d;
        solvedCases=e;
    }

}

