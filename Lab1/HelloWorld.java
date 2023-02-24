

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String []languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);

        n *= 3;
        n += 0b10101;
        n += 0xFF;
        n *= 6;

        int cp = n;

        while (n >= 10){
            n = 0;
            while(cp > 0){
                int x = cp % 10;
                n += x;
                cp /= 10;
            }
            cp = n;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
