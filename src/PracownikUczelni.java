public abstract class PracownikUczelni extends Człowiek implements java.io.Serializable {
    int salary;


    public PracownikUczelni(String name, String lastName, int age, int pesel, int salary) {
        super(name, lastName, age, pesel);
        this.salary = salary;
    }
}