import java.util.Scanner;
public abstract class Człowiek {

    String name;
    String lastName;
    int age;
    int pesel;


    public void searchSpecificMan(){
        Scanner searching = new Scanner(System.in);
        System.out.println("Po jakim parametrze chcesz sukać \n 1.Imie \n 2.Nazwisko \n 3.Wiek \n 4.Nr Pesel \n 5.Sopień naukowy \n PODAJ NR");
        int choose=searching.nextInt();
        switch (choose){
            case 1:
                System.out.println("Podaj Imie");
                if(name.equals(searching.nextLine())){
                    //znaduje takie imiona
                }

                // szukanie po imieniu
                break;
            case 2:
                //szukanie po nazwisku
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }



    }


    public void searchAllMan(){
        System.out.println("Oto wszyscy ptacownicy administracyjni:");
        // WSZYSCY ADMINISTRACYJNI
        System.out.println("A tutaj wszyscy dydaktyczni:");

    }
}
