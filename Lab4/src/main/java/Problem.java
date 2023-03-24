import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
    private Map<Student, List<Project>> prefMap = new HashMap<>();

    void put(Student student, List<Project> projectList){
        prefMap.put(student, projectList);
    }

    public Student getS(Student student) {
        return (Student) prefMap.get(student);
    }

    public Map<Student, List<Project>> getPrefMap() {
        return prefMap;
    }

    public void setPrefMap(Map<Student, List<Project>> prefMap) {
        this.prefMap = prefMap;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "prefMap=" + prefMap +
                '}';
    }
}
