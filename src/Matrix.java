public class Matrix {
    double[][] matrix;
    int m;
    int n;

    public Matrix(double[][] A) {
        matrix = A;
        this.m = A.length;
        this.n = A[0].length;
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
        this.m = m;
        this.n = n;

    }

    public Matrix(int m, int n){
	/**
	m - Number of rows
	n - number of coulmns
	**/
	matrix = new double [m][n];
	for (int i = 0; i<m; i++){
		for (int j = 0; j<n; j++){
		matrix[i][j] = 0;
		}
	}
    this.m = m;
    this.n = n;
  }

    public Matrix(double[] vals, int m){
        if (vals.length % m != 0){
            throw new java.lang.IllegalArgumentException("Array length must be a multiple of m.");
        }
        matrix = new double[m][vals.length / m];
        for (int i = 0; i < vals.length; i++){
            matrix[i % m][i / m] = vals[i];
        }
        this.m = m;
        this.n = vals.length / m;

    }

    public Matrix(double[][] matrix, int m, int n){
        this.matrix = matrix;
        this.m = m;
        this.n = n;
    }

  public Matrix transpose(){
      System.out.println(m);

      System.out.println(n);

        double [][] temp = new double[n][m];

        for (int i =0; i< m; i++){
            for (int j = 0; j < n; j++){
                temp[j][i] = matrix[i][j];
            }
        }
        return new Matrix(temp);
  }

    public Matrix times(Matrix B){
        if (B == null)
            throw new java.lang.IllegalArgumentException("Cannot accept null argument.");

        if (matrix[0].length != B.matrix.length)
            throw new java.lang.IllegalArgumentException("Matrix inner dimensions must agree.");

        double [][] output = new double[matrix.length][B.matrix[0].length];
        for (int i=0; i < output.length; i++){
            //System.out.print(i);
            for (int j=0; j < output[0].length; j++){
                //System.out.print(j);
                for (int k=0; k < matrix[0].length; k++){
                    //System.out.print(k);
                    output[i][j] += matrix[i][k] * B.matrix[k][j];
                }
            }
        }

        return new Matrix(output);
    }

    public static Matrix identity(int m, int n){
        if (m != n)
            return null;
        double[][] temp = new double[m][n];
        for (int i=0; i<m; i++){
            temp[i][i] = 1.;
        }
        return new Matrix(temp);
    }

    public double[][] getArray(){
        return matrix;
    }

    public double[][] getArrayCopy(){
        double[][] output = new double[matrix.length][];
        for (int i=0; i < matrix.length; i++){
            output[i] = matrix[i].clone();
        }
        return output;
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

    public double get(int i, int j){
	return matrix[i][j];
}


}
