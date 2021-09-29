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
   
    public Matrix(int m, int n){
	/**
	m - Number of rows
	n - number of coulmns
	**/
	matrix = new double [m][n]
	for (int i = 0; i<m; i++){
		for (int j = 0; j<n; j++){
		matrix[i][j] = 0;
		}
	}
  }    
 

    public Matrix times(Matrix B){
        if (B == null)
            throw new java.lang.IllegalArgumentException("Cannot accept null argument.");

        if (matrix[0].length != B.matrix.length)
            throw new java.lang.IllegalArgumentException("Matrix inner dimensions must agree.");

        double [][] output = new double[matrix.length][B.matrix[0].length];
        for (int i=0; i < output.length; i++){
            System.out.print(i);
            for (int j=0; j < output[0].length; j++){
                System.out.print(j);
                for (int k=0; k < matrix[0].length; k++){
                    System.out.print(k);
                    output[i][j] += matrix[i][k] * B.matrix[k][j];
                }
            }
        }

        return new Matrix(output);
    }

    public double[][] getArray(){
        return matrix;
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
