import java.util.Scanner;

public class pracownikAdministracyjny extends pracownikUczelni {
    int solvedCases;
    Scanner getter=new Scanner(System.in);

    public void makeAministration(){
        name=getter.nextLine();
        lastName=getter.nextLine();
        age=getter.nextInt();
        public pracownikAdministracyjny(name, lastName, age) {
            name=name;
        }
        // TYlko wywołać konstruktor, a zdefiniowac go trzeba osobno.
    }
}
