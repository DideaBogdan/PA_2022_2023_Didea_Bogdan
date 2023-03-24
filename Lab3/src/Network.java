import javax.swing.*;
import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network() {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void setImportances(){
        nodes.forEach((temp)->{
            temp.setImportance();
        });
        Collections.sort(nodes, (o1, o2) -> o2.getImportance() - o1.getImportance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return Objects.equals(nodes, network.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
