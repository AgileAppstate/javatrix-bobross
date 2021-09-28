public class Matrix {
    double[][] matrix;

    public Matrix(double[][] A) {
        matrix = A;
    }

    public Matrix(int m, int n, double s) {
        /**
         m - Number of rows.
         n - Number of colums.
         s - Fill the matrix with this scalar value.
         **/

        matrix = new double[m][n];
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                matrix[i][j] = s;
            }
        }

    }

    public void print(int a, int b){
        String format = "%" + a + "." + b + "f ";
        for(int i=0; i < matrix.length;i++){
            for(int j=0; j < matrix[0].length; j++){
                System.out.printf(format, matrix[i][j]);
            }
            System.out.println();
        }
    }


}
