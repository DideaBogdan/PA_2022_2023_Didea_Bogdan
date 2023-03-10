import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();

        Node p1 = new Person("persoana1");
        Node p2 = new Person("persoana2");
        Node c1 = new Company("companie1");
        Node c2 = new Company("companie2");
        list.add(p1);
        list.add(p2);
        list.add(c1);
        list.add(c2);
        System.out.println(list);
    }
}
