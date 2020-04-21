import java.io.IOException;
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
                        System.out.println(uczelnia.lookingForAdminByName(tempName).name);

                        break;
                    case 2:
                        uczelnia.lookingForAdminByLastName();
                        break;
                    case 3:
                       uczelnia.lookingForAdminBySalary();
                        break;
                    case 4:
                        uczelnia.lookingForAdminBySolvedCases();
                        break;
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
                        uczelnia.lookingForTeacherByName();
                        break;
                    case 2:
                        uczelnia.lookingForTeacherByLastName();
                        break;
                    case 3:
                        uczelnia.lookingForTeacherBySalary();
                        break;
                    case 4:
                        uczelnia.lookingForTeacherByDegree();
                        break;
                    case 5:
                        uczelnia.lookingForTeacherBySciPublication();
                        break;
                }
                break;
            case 5:
                //usuwanie administracji
                break;
            case 6:
                //usuwanie nauczycieli
                break;

        }



    }
}
