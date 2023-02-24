

public class Homework {
    public static void main(String[] args) {
        int n = 0;
        if (args.length != 1) {
            System.err.print("Enter just one argument, an integer!!");
            System.exit(1);
        }
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException numb) {
            System.err.print("The argument must be an integer!!");
            System.exit(1);
        }
        if (n < 1) {
            System.err.print("The argument must be at least one!!");
            System.exit(1);
        }
        long startTime = 0;
        long endTime = 0;
        if (n > 50){
            startTime = System.nanoTime();
        }

        int [][]latinMatrix = new int[n][n];

        for (int i = 0; i < n; i++){
            int count = i+1;
            for (int j = 0; j < n; j++){
                if (count > n) count = 1;
                latinMatrix[i][j] = count;
                count++;
            }
        }

        if (n > 50){
            endTime = System.nanoTime();
            System.out.println(endTime - startTime + " nanoseconds ");
        }else {
            for (int i = 0; i < n; i++){
                StringBuilder sbLines = new StringBuilder();
                StringBuilder sbColumns = new StringBuilder();
                for (int j = 0; j < n; j++){
                    sbLines.append(latinMatrix[i][j]);
                    sbColumns.append(latinMatrix[j][i]);
                }
                System.out.println(sbLines);
                System.out.println(sbColumns);
            }
        }

    }
}
