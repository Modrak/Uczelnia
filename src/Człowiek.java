//REGULACJA PESEL JAK ZROBIC

public abstract class Człowiek implements java.io.Serializable {

    String name;
    String lastName;
    int age;
    int pesel;


    public Człowiek(String name, String lastName, int age, int pesel) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.pesel = pesel;
    }
}




