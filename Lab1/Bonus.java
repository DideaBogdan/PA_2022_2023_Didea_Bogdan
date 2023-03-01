public class Bonus {

    public static void main(String[] args) {
        int n = 0;
        int degree = 0;
        if (args.length < 2) {
            System.err.print("You need 2 arguments, integers");
            System.exit(1);
        }
        try {
            n = Integer.parseInt(args[0]);
            degree = Integer.parseInt(args[1]);
        } catch (NumberFormatException numb) {
            System.err.print("The argument must be an integer!!");
            System.exit(1);
        }
        if (n < 1) {
            System.err.print("The argument must be at least one!!");
            System.exit(1);
        }

        // 1
        int [][]adjacencyMatrix =new  int [n][n];
        int i = 0;
        while ( i < n - 1) {
            adjacencyMatrix[i][i+1] = 1;
            adjacencyMatrix[i+1][i] = 1;
            i++;
        }
        adjacencyMatrix[0][n-1] = 1;
        adjacencyMatrix[n-1][0] = 1;


        int [][]auxMatrix = new int[n][n];
        auxMatrix = adjacencyMatrix;

        for(i=1; i<=n; i++) {
            int[][] adjacencyMatrixPowerN = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int x = 0; x < n; x++) {
                        adjacencyMatrixPowerN[j][k] += auxMatrix[j][x] * adjacencyMatrix[x][k];
                    }
                }
            }
            auxMatrix = adjacencyMatrixPowerN;
        }

        for(i = 0; i < n ; i++){
            for(int j = 0; j < n; j ++ ){
                System.out.print(auxMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        //2
    /*
        if( n * degree % 2 == 1){
            System.err.print("Can't be done! Make sure the product of the number of vertices and degree is even");
            System.exit(1);
        }
        int [][]adjacencyMatrixRegularGraph = new int[n][n];

        for( i = 0; i < n; i ++){
            for(int j = i+1; j < n; j++){
                if((j-i) % n < degree){
                    adjacencyMatrixRegularGraph[i][j] = 1;
                    adjacencyMatrixRegularGraph[j][i] = 1;
                }
            }
        }

        for(i = 0; i < n ; i++){
            for(int j = 0; j < n; j ++ ){
                System.out.print(adjacencyMatrixRegularGraph[i][j] + " ");
            }
            System.out.print("\n");
        }
    */
    }
}