public class PracownikDydaktyczny extends PracownikUczelni implements java.io.Serializable {
    int sciPublication;
    String degree;

    public PracownikDydaktyczny(String name, String lastName, int age, int pesel, int salary, int sciPublication, String degree)
    {
        super(name,lastName,age,pesel,salary);
        this.sciPublication=sciPublication;
        this.degree=degree;
    }

}
