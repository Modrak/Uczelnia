import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uczelnia {
    List<PracownikAdministracyjny> administration = new ArrayList<PracownikAdministracyjny>();
    List<PracownikDydaktyczny> teachers = new ArrayList<PracownikDydaktyczny>();
    Scanner geting = new Scanner(System.in);
    public void addingAdministration(){

        String a=geting.nextLine();
        String b=geting.nextLine();
        int c=geting.nextInt();
        int d=geting.nextInt();
        int e=geting.nextInt();

        administration.add(new PracownikAdministracyjny(a,b,c,d,e));
    }
    public void addingTeacher(){
        String filename = "Teachers.ser";
        //Updating List
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
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

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(teachers);
            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }
        catch(IOException ex)
        {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());

        }
            //deserialize
        try
        {

            FileInputStream file = new FileInputStream(filename);
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
