public class PracownikDydaktyczny extends PracownikUczelni implements java.io.Serializable {
    int sciPublication;
    String degree;

    public PracownikDydaktyczny(String a, String b, String c, int d, int e, int f, int g) {
        name=a;
        lastName=b;
        degree=c;
        age=d;
        pesel=e;
        sciPublication=f;
        salary=g;
    }
}
