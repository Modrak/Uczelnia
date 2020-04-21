import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {

        Scanner menu =new Scanner(System.in);
        Uczelnia uczelnia=new Uczelnia();
        System.out.println("Co chcesz zrobić: (podaj nr)");
        System.out.println("1. Dodać pracownika administracji ");
        System.out.println("2. Dodać nauczyciela ");
        System.out.println("3. Znaleźć pracownika administracji ");
        System.out.println("4. Znaleźć nauczyciela ");
        System.out.println("5. Usunąć pracownika administracji ");
        System.out.println("6. Usunąć nauczyciela ");
        int choose=0;
        try {
            choose = menu.nextInt();
            menu.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Podaj cyfre!");
        }
        switch (choose){
            case 1:
                uczelnia.addingAdministration();
                break;
            case 2:
                uczelnia.addingTeacher();
                break;
            case 3:
                System.out.println("Jak chcesz go znaleźć");
                System.out.println("1. Po imieniu");
                System.out.println("2. Po nazwisku");
                System.out.println("3. Po zarobkach");
                System.out.println("4. Po ilości rozwiązanych spraw");

                int chooseCase3= menu.nextInt();
                menu.nextLine();
                switch (chooseCase3){
                    case 1:

                        System.out.println("Podaj imie: ");
                        String tempName =menu.nextLine();
                        System.out.println("SZUKANIE");
                        try {
                            System.out.println("Imie: " + uczelnia.lookingForAdminByName(tempName).name);
                            System.out.println("Nazwisko: " + uczelnia.lookingForAdminByName(tempName).lastName);
                            System.out.println("Wiek: " + uczelnia.lookingForAdminByName(tempName).age);
                            System.out.println("Nr na liście: " + uczelnia.positionInArrayOfAdmin(uczelnia.lookingForAdminByName(tempName).name)); //JAK DODAC NR NA LISCIE ??
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znaleziono nikogo o imieniu "+ tempName);
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Podaj szukane nazwisko:");
                            String tempLastName = menu.nextLine();
                            System.out.println("Oto znaleziony człowiek:");
                            System.out.println("Imie: " + uczelnia.lookingForAdminByLastName(tempLastName).name);
                            System.out.println("Nazwisko: " + uczelnia.lookingForAdminByLastName(tempLastName).lastName);
                            System.out.println("Wiek: " + uczelnia.lookingForAdminByLastName(tempLastName).age);
                            System.out.println("Wypłata: " + uczelnia.lookingForAdminByLastName(tempLastName).salary);
                            System.out.println("Nr na liscie: " + uczelnia.positionInArrayOfAdmin(uczelnia.lookingForAdminByLastName(tempLastName).name));
                            break;
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znaleziono nikogo");
                        }
                    case 3:
                        try {
                            System.out.println("Podaj szukane zarobki");
                            int tempSalary = menu.nextInt();
                            System.out.println("Oto znaleziony człowiek:");
                            System.out.println("Imie: " + uczelnia.lookingForAdminBySalary(tempSalary).name);
                            System.out.println("Nazwisko: " + uczelnia.lookingForAdminBySalary(tempSalary).lastName);
                            System.out.println("Wiek: " + uczelnia.lookingForAdminBySalary(tempSalary).age);
                            System.out.println("Wypłata: " + uczelnia.lookingForAdminBySalary(tempSalary).salary);
                            System.out.println("Nr na liscie: " + uczelnia.positionInArrayOfAdmin(uczelnia.lookingForAdminBySalary(tempSalary).name));
                            break;
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znaleziono nikogo");
                        }
                    case 4:
                        try {
                            System.out.println("Podaj ilość rozwiązanych spraw");
                            int tempSolvedCases=menu.nextInt();
                            System.out.println("Oto znaleziony człowiek:");
                            System.out.println("Imie: " + uczelnia.lookingForAdminBySolvedCases(tempSolvedCases).name);
                            System.out.println("Nazwisko: " + uczelnia.lookingForAdminBySolvedCases(tempSolvedCases).lastName);
                            System.out.println("Wiek: " + uczelnia.lookingForAdminBySolvedCases(tempSolvedCases).age);
                            System.out.println("Wypłata: " + uczelnia.lookingForAdminBySolvedCases(tempSolvedCases).salary);
                            System.out.println("Nr na liscie: " + uczelnia.positionInArrayOfAdmin(uczelnia.lookingForAdminBySolvedCases(tempSolvedCases).name));
                            break;
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znalezniono nikogo");
                        }
                }

                break;


            case 4:
                System.out.println("Jak chcesz go znaleźć");
                System.out.println("1. Po imieniu");
                System.out.println("2. Po nazwisku");
                System.out.println("3. Po zarobkach");
                System.out.println("4. Po stopniu naukowym");
                System.out.println("5. Po ilości publikacji");

                int chooseCase4= menu.nextInt();
                switch (chooseCase4){
                    case 1:
                        try {
                            System.out.println("Podaj imie:");
                            String tempName = menu.nextLine();
                            System.out.println("Znaleziono takiego człowieka");
                            uczelnia.presentTeacher(uczelnia.lookingForTeacherByName(tempName).name);
                            break;
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znaleziono nikogo o takim imieniu");
                        }
                    case 2:
                        try{
                            System.out.println("Podaj nazwisko:");
                            String tempLastName=menu.nextLine();
                            uczelnia.presentTeacher(uczelnia.lookingForTeacherByLastName(tempLastName).name);
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znaleziono nikogo takiego");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Podaj szukane zarobki");
                            int tempSalary = menu.nextInt();
                            uczelnia.presentTeacher(uczelnia.lookingForTeacherBySalary(tempSalary).name);
                            break;
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znaleziono nikogo takiego");
                        }
                    case 4:
                        try {
                            System.out.println("Podaj szukany stopień:");
                            String tempDegree = menu.nextLine();
                            uczelnia.presentTeacher(uczelnia.lookingForTeacherByDegree(tempDegree).name);
                            break;
                        }
                        catch (NullPointerException e){
                            System.out.println("Nikogo takiego nie znaleziono");
                        }
                    case 5:
                        System.out.println("Podaj szukaną ilość publikacji:");
                        int sciPub=menu.nextInt();
                        try {
                            uczelnia.presentTeacher(uczelnia.lookingForTeacherBySciPublication(sciPub).name);
                            break;
                        }
                        catch (NullPointerException e){
                            System.out.println("Nie znaleziono nikogo o takiej ilości publikacji");
                        }

                }
                break;
            case 5:
                //usuwanie administracji
                break;
            case 6:
                System.out.println("Podaj index naucyciela do usunięcia");
                int index=menu.nextInt();
                uczelnia.removingTeacher(index);
                break;

        }


            //konik testowy dodany do commitowania repo

    }
}
