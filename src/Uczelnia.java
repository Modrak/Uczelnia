import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Uczelnia {
    List<PracownikAdministracyjny> administration = new ArrayList<PracownikAdministracyjny>();
    List<PracownikDydaktyczny> teachers = new ArrayList<PracownikDydaktyczny>();
    Scanner geting = new Scanner(System.in);

    public Uczelnia() {
        try {
            String adminFileName="Administration.txt";
            File adminFile=new File(adminFileName);
            adminFile.createNewFile();
            FileInputStream fileAdmin = new FileInputStream(adminFileName);
            ObjectInputStream inAdmin = new ObjectInputStream(fileAdmin);
            administration = (ArrayList<PracownikAdministracyjny>) inAdmin.readObject();
        }
        catch(EOFException e){
            System.out.println("Plik jest pusty");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            String teacherFileName="Teachers.txt";
            File teachersFile=new File(teacherFileName);
            teachersFile.createNewFile();

            FileInputStream fileTeachers = new FileInputStream("Teachers.txt");
            ObjectInputStream inTeachers = new ObjectInputStream(fileTeachers);
            teachers = (ArrayList<PracownikDydaktyczny>) inTeachers.readObject();
        }
        catch(EOFException e){
            System.out.println("Plik jest pusty");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

        public void addingAdministration() {

            System.out.println(administration.size());
            System.out.println("Podaj imie:");
            String name = geting.nextLine();
            System.out.println("Podaj nazwisko:");
            String lastName = geting.nextLine();
            System.out.println("Podaj wiek:");
            try {
                int age = geting.nextInt();
                System.out.println("Podaj PESEL:");
                int pesel = geting.nextInt();
                System.out.println("Podaj wypłate:");
                int salary = geting.nextInt();
                System.out.println("Podaj ilość rozwiązanych spraw:");
                int solvedCases = geting.nextInt();

                administration.add(new PracownikAdministracyjny(name, lastName, age, pesel, salary, solvedCases));

            } catch (InputMismatchException e) {
                System.out.println("Należy podawać liczby.");
            }

                //Serializacja
            try {
                System.out.println(administration.get(administration.size()-1).name);
                System.out.println(administration.get(administration.size()-1).lastName);
                System.out.println(administration.get(administration.size()-1).age);
                System.out.println(administration.size());
                FileOutputStream file = new FileOutputStream("Administration.txt");
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(administration);
                out.close();
                file.close();

                System.out.println("New admin has been added");

            }
            catch (IOException ex) {
                System.out.println(ex.getCause());
                System.out.println(ex.getMessage());
            }



    }
    public PracownikAdministracyjny lookingForAdminByName(String tempName){

        try {
            for (int i = 0; i < administration.size(); i++) {
                if (administration.get(i).name.equals(tempName)) {
                    return administration.get(i);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Nie znaleziono nikogo o takim imieniu. :C");
        }

        return null;

    }



    public int positionInArrayOfAdmin(String nameOfAdmin){
        for(int i=0; i<administration.size(); i++){
            if(nameOfAdmin.equals(administration.get(i).name)){
                return i;
            }
        }

        return 9999;
    }




    public PracownikAdministracyjny lookingForAdminByLastName(String tempLastName){


        for(int i=0; i<administration.size(); i++){
            if(tempLastName.equals(administration.get(i).lastName)){
                return administration.get(i);
            }
        }
        return null;
    }

    public PracownikAdministracyjny lookingForAdminBySalary(int tempSalary){
        for (int i=0;i<administration.size();i++){
            if (tempSalary==administration.get(i).salary){
                return administration.get(i);
            }
        }
    return null;
    }

    public PracownikAdministracyjny lookingForAdminBySolvedCases(int tempSolvedCases) {
        for (int i=0;i<administration.size();i++){
            if (tempSolvedCases==administration.get(i).solvedCases){
                return administration.get(i);
            }
        }
        return null;
    }

    public void presentAdmin(String name){
        for (int i=0;i<administration.size();i++){
            if (administration.get(i).name.equals(name)){
                System.out.println("Imie: "+administration.get(i).name);
                System.out.println("Nazwisko: "+administration.get(i).lastName);
                System.out.println("Wiek: "+administration.get(i).age);
                System.out.println("Wypłata: "+administration.get(i).salary);
                System.out.println("Rozwiązane sprawy: "+administration.get(i).solvedCases);
            }
        }

    }



    public void addingTeacher(){

        //Adding a new one to list
        String name=geting.nextLine();
        String lastName=geting.nextLine();
        int age=geting.nextInt();
        int pesel=geting.nextInt();
        int salary=geting.nextInt();
        int sciPublication=geting.nextInt();
        String degree=geting.nextLine();

        teachers.add(new PracownikDydaktyczny(name, lastName,age,pesel,salary,sciPublication,degree));

        //Serializing
        try
        {

            FileOutputStream file = new FileOutputStream("Teachers.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(teachers);
            out.close();
            file.close();

            System.out.println("New teacher has beed added");

        }
        catch(IOException ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        }
    }

    public PracownikDydaktyczny lookingForTeacherByName(String tempName){
        for (int i=0;i<teachers.size();i++){
            if (tempName.equals(teachers.get(i).name)){
                return teachers.get(i);
            }
        }
        return null;
    }


    public PracownikDydaktyczny lookingForTeacherByLastName(String tempLastName){
        for (int i=0;i<teachers.size();i++){
            if (tempLastName.equals(teachers.get(i).lastName)){
                return teachers.get(i);
            }
        }
        return null;
    }



    public PracownikDydaktyczny lookingForTeacherBySalary(int tempSalary){
        for (int i=0;i<teachers.size();i++){
            if (tempSalary==teachers.get(i).salary){
                return teachers.get(i);
            }
        }
        return null;
    }

    public PracownikDydaktyczny lookingForTeacherByDegree(String tempDegree){
        for (int i=0;i<teachers.size();i++){
            if (tempDegree.equals(teachers.get(i).degree)){
                return teachers.get(i);
            }
        }
        return null;


    }

    public PracownikDydaktyczny lookingForTeacherBySciPublication(int sciPub){
        for(int i=0;i<teachers.size();i++){
            if (teachers.get(i).sciPublication==sciPub){
                return teachers.get(i);
            }
        }

        return null;
    }
    public void presentTeacher(String name){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).name.equals(name)){
                System.out.println("Imie: "+teachers.get(i).name);
                System.out.println("Nazwisko: "+teachers.get(i).lastName);
                System.out.println("Wiek: "+teachers.get(i).age);
                System.out.println("Wypłata: "+teachers.get(i).salary);
                System.out.println("Ilość publikacji: "+teachers.get(i).sciPublication);
                System.out.println("Stopien naukowy: "+teachers.get(i).degree);
            }
        }

    }

    public void removingTeacher (int index){
        System.out.println("Czy chodzi o pana "+teachers.get(index).name+" "+teachers.get(index).lastName+" ?");
        System.out.println("Wybierz: 1/0");
        int chooseRemove=geting.nextInt();
        if(chooseRemove == 1){
            teachers.remove(index);
        } else if(chooseRemove == 0){
            System.out.println("Nie usunieto tego pracownika. Tym razem.");
        }
        else {
            System.out.println("Wybrano złą cyfre. Wybierz 1 lub 0");
        }
    }


    public int salaryOfEveryOne(){
        int salaryForTeachers=0;
        for (int i=0;i<teachers.size();i++){
            salaryForTeachers= salaryForTeachers+teachers.get(i).salary;
        }
        int salaryForAdmins=0;
        for (int i=0;i<administration.size();i++){
            salaryForAdmins=salaryForAdmins+administration.get(i).salary;
        }
        return salaryForAdmins+salaryForTeachers;
    }



}
