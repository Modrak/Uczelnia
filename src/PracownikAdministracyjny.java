import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class PracownikAdministracyjny  extends PracownikUczelni implements java.io.Serializable {

    int solvedCases;


    public PracownikAdministracyjny(String a, String b, int c, int d, int e, int f) {
        name=a;
        lastName=b;
        age=c;
        pesel=d;
        salary=e;
        solvedCases=f;
    }

}

