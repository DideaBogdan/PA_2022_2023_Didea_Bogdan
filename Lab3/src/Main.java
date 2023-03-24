import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();

        Person p1 = new Person("persoana1", "01/01/1990");
        Person p2 = new Person("persoana2", "01/01/1990");
        Company c1 = new Company("companie1");
        Company c2 = new Company("companie2");
        list.add(p1);
        list.add(p2);
        list.add(c1);
        list.add(c2);

        p1.addRelationship(p2, "boss");
        c2.addRelationship(p1, "employee");
        Person p3 = new Programmer("Eula","01/01/1990" ,34);
        Person p4 = new Designer("Eula","01/01/1990" ,56);
        p3.addRelationship(p4, "co-worker");
        p4.addRelationship(p3, "best-friend");
        p1.addRelationship(c1, "employer");

        list.add(p3);
        list.add(p4);
        System.out.println("Print of the list of compulsory-----------------------------------------");
        list.forEach(System.out::println);

        Network network = new Network();
        network.addNode(p1);
        network.addNode(p2);
        network.addNode(c1);
        network.addNode(c2);
        network.addNode(p3);
        network.addNode(p4);
        network.setImportances();
        System.out.println("Print of the network of nodes, ordered by the importance------------------------------------------");
        network.getNodes().forEach(System.out::println);
    }
}
