import com.github.javafaker.Faker;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(1,3)
                .mapToObj(i -> new Student("S" + (4-i)))
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(1,3)
                .mapToObj(i -> new Project("P" + (4-i)))
                .toArray(Project[]::new);

        System.out.println("Array-ul initial de studenti");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("Array-ul initial de proiecte");
        for (Project project : projects) {
            System.out.println(project);
        }

        List<Student> listOfStudents = new LinkedList<>();
        for(Student s : students){
            listOfStudents.add(s);
        }
        //sortarea

        Collections.sort(listOfStudents);
        /*
        Collections.sort(listOfStudents,
                (u,v) -> u.getName().compareTo(v.getName()));
        */

        List<Student> newSortedList = listOfStudents.stream()
                        .sorted(Comparator.comparing(Student::getName))
                                .collect(Collectors.toList());
        System.out.println("Lista de studenti initiala sortata cu sort");
        System.out.println(listOfStudents);
        System.out.println("Lista de studenti sortata cu stream");
        System.out.println(newSortedList);


        SortedSet listOfProjects = new TreeSet();
        for(Project p : projects){
            listOfProjects.add(p);
        }
        System.out.println("Lista de proiecte sortata");
        System.out.println(listOfProjects);


        /*HOMEWORK*/
        Faker faker = new Faker();

        var fakeStudents = IntStream.rangeClosed(1,50)
                .mapToObj(i -> new Student(faker.name().firstName()))
                .toList();
        /*
        for (Student student : fakeStudents) {
            System.out.println(student);
        }
        */
        var fakeProjects = IntStream.rangeClosed(1,50)
                .mapToObj(i -> new Project(faker.app().name()))
                .toList();
        /*
        for (Project project : fakeProjects) {
            System.out.println(project);
        }
        */

        Problem problem = new Problem();

        for(Student student: fakeStudents){
            int n = (int) (Math.random() * (42));
            problem.put(student, fakeProjects.subList(n, n+1+(int) (Math.random() * (7))));
        }
        System.out.println(problem);

        /*

        List<Project> taken = fakeProjects;

        List<Student> underAverage = fakeStudents.stream()
                .filter(s->problem.getPrefMap().get(s))
                .collect(Collectors.toList());

        System.out.println(underAverage);
         */
    }
}
