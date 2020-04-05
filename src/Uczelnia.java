import java.io.*;
import java.util.ArrayList;
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


        String a=geting.nextLine();
        String b=geting.nextLine();
        int c=geting.nextInt();
        int d=geting.nextInt();
        int e=geting.nextInt();
        int f=geting.nextInt();

        administration.add(new PracownikAdministracyjny(a,b,c,d,e,f));

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



}
