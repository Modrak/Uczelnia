import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Uczelnia {
    List<PracownikAdministracyjny> administration = new ArrayList<PracownikAdministracyjny>();
    List<PracownikDydaktyczny> teachers = new ArrayList<PracownikDydaktyczny>();
    Scanner geting = new Scanner(System.in);

    public void addingAdministration(){
        String fileName="Administration.ser";
        //Updating List

        try {
            // Reading the object from a file

            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            administration = (ArrayList<PracownikAdministracyjny>) in.readObject();
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

        System.out.println("Podaj imie:");
        String a=geting.nextLine();
        System.out.println("Podaj nazwisko:");
        String b=geting.nextLine();
        System.out.println("Podaj wiek:");
        try {
            int c = geting.nextInt();
            System.out.println("Podaj PESEL:");
            int d = geting.nextInt();
            System.out.println("Podaj wypłate:");
            int e = geting.nextInt();
            System.out.println("Podaj ilość rozwiązanych spraw:");
            int f = geting.nextInt();

            administration.add(new PracownikAdministracyjny(a,b,c,d,e,f));
        }

        catch (InputMismatchException e) {
            System.out.println("Należy podawać liczby.");
        }


        try
        {

            FileOutputStream file = new FileOutputStream("Administration.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(administration);
            out.close();
            file.close();

            System.out.println("New admin has been added");

        }
        catch(IOException ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        }
        //deserialize
        try
        {

            FileInputStream file = new FileInputStream("Administration.ser");
            ObjectInputStream in = new ObjectInputStream(file);


            administration = (ArrayList<PracownikAdministracyjny>)in.readObject();
            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println(administration.size());


        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }


    }

    public void lookingForAdminByName(){

        try {

            FileInputStream file = new FileInputStream("Administration.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            administration = (ArrayList<PracownikAdministracyjny>) in.readObject();
            System.out.println("Podaj imie które chcesz znaleźć");
            String tempName=geting.nextLine();
            for(int i=1; i<=administration.size(); i++){
                if(tempName.equals(administration.get(i-1).name)){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+administration.get(i-1).name);
                    System.out.println("Nazwisko: "+administration.get(i-1).lastName);
                    System.out.println("Wiek: "+administration.get(i-1).age);
                    System.out.println("PESEL: "+administration.get(i-1).pesel);
                    System.out.println("Wypłata: "+administration.get(i-1).salary);
                    System.out.println("Rozwiązane sprawy: "+administration.get(i-1).solvedCases);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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


    }

    public void lookingForAdminByLastName(){

        try {

            FileInputStream file = new FileInputStream("Administration.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            administration = (ArrayList<PracownikAdministracyjny>) in.readObject();
            System.out.println("Podaj imie które chcesz znaleźć");
            String tempLastName=geting.nextLine();
            for(int i=1; i<=administration.size(); i++){
                if(tempLastName.equals(administration.get(i-1).lastName)){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+administration.get(i-1).name);
                    System.out.println("Nazwisko: "+administration.get(i-1).lastName);
                    System.out.println("Wiek: "+administration.get(i-1).age);
                    System.out.println("PESEL: "+administration.get(i-1).pesel);
                    System.out.println("Wypłata: "+administration.get(i-1).salary);
                    System.out.println("Rozwiązane sprawy: "+administration.get(i-1).solvedCases);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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


    }

    public void lookingForAdminBySalary(){

        try {

            FileInputStream file = new FileInputStream("Administration.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            administration = (ArrayList<PracownikAdministracyjny>) in.readObject();
            System.out.println("Podaj dolny zakres zarobków:");
            int bottomSalary=geting.nextInt();
            System.out.println("Podaj górny zakres zarobków: ");
            int topSalary=geting.nextInt();
            for(int i=1; i<=administration.size(); i++){
                if(bottomSalary<administration.get(i-1).salary) && administration.get(i-1).salary<topSalary){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+administration.get(i-1).name);
                    System.out.println("Nazwisko: "+administration.get(i-1).lastName);
                    System.out.println("Wiek: "+administration.get(i-1).age);
                    System.out.println("PESEL: "+administration.get(i-1).pesel);
                    System.out.println("Wypłata: "+administration.get(i-1).salary);
                    System.out.println("Rozwiązane sprawy: "+administration.get(i-1).solvedCases);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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


    }

    public void lookingForAdminBySolvedCases(){

        try {

            FileInputStream file = new FileInputStream("Administration.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            administration = (ArrayList<PracownikAdministracyjny>) in.readObject();
            System.out.println("Podaj dolny zakres zarobków:");
            int bottomCases=geting.nextInt();
            System.out.println("Podaj górny zakres zarobków: ");
            int topCases=geting.nextInt();
            for(int i=1; i<=administration.size(); i++){
                if(bottomCases<administration.get(i-1).solvedCases) && administration.get(i-1).solvedCases<topCases){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+administration.get(i-1).name);
                    System.out.println("Nazwisko: "+administration.get(i-1).lastName);
                    System.out.println("Wiek: "+administration.get(i-1).age);
                    System.out.println("PESEL: "+administration.get(i-1).pesel);
                    System.out.println("Wypłata: "+administration.get(i-1).salary);
                    System.out.println("Rozwiązane sprawy: "+administration.get(i-1).solvedCases);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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


    }



    public void addingTeacher(){

        //Updating List
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("Teachers.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            teachers = (ArrayList<PracownikDydaktyczny>) in.readObject();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Adding a new one to list
        String a=geting.nextLine();
        String b=geting.nextLine();
        String c=geting.nextLine();
        int d=geting.nextInt();
        int e=geting.nextInt();
        int f=geting.nextInt();
        int g=geting.nextInt();

        teachers.add(new PracownikDydaktyczny(a,b,c,d,e,f,g));

        //Serializing
        try
        {

            FileOutputStream file = new FileOutputStream("Teachers.ser");
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
            //deserialize
        try
        {

            FileInputStream file = new FileInputStream("Teachers.ser");
            ObjectInputStream in = new ObjectInputStream(file);

          
            teachers = (ArrayList<PracownikDydaktyczny>)in.readObject();
            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println(teachers.size());


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void lookingForTeacherByName(){
        try {

            FileInputStream file = new FileInputStream("Teacher.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            teachers = (ArrayList<PracownikDydaktyczny>) in.readObject();
            System.out.println("Podaj imie które chcesz znaleźć");
            String tempName=geting.nextLine();
            for(int i=1; i<=teachers.size(); i++){
                if(tempName.equals(teachers.get(i-1).name)){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+teachers.get(i-1).name);
                    System.out.println("Nazwisko: "+teachers.get(i-1).lastName);
                    System.out.println("Stopień naukowy: "+ teachers.get(i-1).degree);
                    System.out.println("Wiek: "+teachers.get(i-1).age);
                    System.out.println("PESEL: "+teachers.get(i-1).pesel);
                    System.out.println("Wypłata: "+teachers.get(i-1).salary);
                    System.out.println("Ilość publikacji: "+teachers.get(i-1).sciPublication);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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
    }

    public void lookingForTeacherByLastName(){
        try {

            FileInputStream file = new FileInputStream("Teacher.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            teachers = (ArrayList<PracownikDydaktyczny>) in.readObject();
            System.out.println("Podaj nazwisko które chcesz znaleźć");
            String tempName=geting.nextLine();
            for(int i=1; i<=teachers.size(); i++){
                if(tempName.equals(teachers.get(i-1).lastName)){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+teachers.get(i-1).name);
                    System.out.println("Nazwisko: "+teachers.get(i-1).lastName);
                    System.out.println("Stopień naukowy: "+ teachers.get(i-1).degree);
                    System.out.println("Wiek: "+teachers.get(i-1).age);
                    System.out.println("PESEL: "+teachers.get(i-1).pesel);
                    System.out.println("Wypłata: "+teachers.get(i-1).salary);
                    System.out.println("Ilość publikacji: "+teachers.get(i-1).sciPublication);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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
    }


    public void lookingForTeacherBySalary(){
        try {

            FileInputStream file = new FileInputStream("Teacher.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            teachers = (ArrayList<PracownikDydaktyczny>) in.readObject();
            System.out.println("Podaj dolny zakres zarobków:");
            int bottomSalary=geting.nextInt();
            System.out.println("Podaj górny zakres zarobków: ");
            int topSalary=geting.nextInt();
            for(int i=1; i<=teachers.size(); i++){
                if(bottomSalary<teachers.get(i-1).salary && teachers.get(i-1).salary<topSalary){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+teachers.get(i-1).name);
                    System.out.println("Nazwisko: "+teachers.get(i-1).lastName);
                    System.out.println("Stopień naukowy: "+ teachers.get(i-1).degree);
                    System.out.println("Wiek: "+teachers.get(i-1).age);
                    System.out.println("PESEL: "+teachers.get(i-1).pesel);
                    System.out.println("Wypłata: "+teachers.get(i-1).salary);
                    System.out.println("Ilość publikacji: "+teachers.get(i-1).sciPublication);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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
    }

    public void lookingForTeacherByDegree(){
        try {

            FileInputStream file = new FileInputStream("Teacher.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            teachers = (ArrayList<PracownikDydaktyczny>) in.readObject();
            System.out.println("Podaj stopień naukowy który chcesz znaleźć:");
            String tempName=geting.nextLine();
            for(int i=1; i<=teachers.size(); i++){
                if(tempName.equals(teachers.get(i-1).degree)){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+teachers.get(i-1).name);
                    System.out.println("Nazwisko: "+teachers.get(i-1).lastName);
                    System.out.println("Stopień naukowy: "+ teachers.get(i-1).degree);
                    System.out.println("Wiek: "+teachers.get(i-1).age);
                    System.out.println("PESEL: "+teachers.get(i-1).pesel);
                    System.out.println("Wypłata: "+teachers.get(i-1).salary);
                    System.out.println("Ilość publikacji: "+teachers.get(i-1).sciPublication);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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
    }

    public void lookingForTeacherBySciPublication(){
        try {

            FileInputStream file = new FileInputStream("Teacher.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            teachers = (ArrayList<PracownikDydaktyczny>) in.readObject();
            System.out.println("Podaj dolny zakres publikacji:");
            int bottomSciPub=geting.nextInt();
            System.out.println("Podaj górny zakres publikacji: ");
            int topSciPub=geting.nextInt();
            for(int i=1; i<=teachers.size(); i++){
                if(bottomSciPub<teachers.get(i-1).salary && teachers.get(i-1).salary<topSciPub){
                    System.out.println("Oto "+i+" znaleziony pracownik");
                    System.out.println("Imie: "+teachers.get(i-1).name);
                    System.out.println("Nazwisko: "+teachers.get(i-1).lastName);
                    System.out.println("Stopień naukowy: "+ teachers.get(i-1).degree);
                    System.out.println("Wiek: "+teachers.get(i-1).age);
                    System.out.println("PESEL: "+teachers.get(i-1).pesel);
                    System.out.println("Wypłata: "+teachers.get(i-1).salary);
                    System.out.println("Ilość publikacji: "+teachers.get(i-1).sciPublication);
                    System.out.println("Nr w tabeli: "+i);
                }
            }
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
    }





}
