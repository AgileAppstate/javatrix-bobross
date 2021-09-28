public class Matrix {
    double[][] matrix;

    private Matrix(double[][] A){
        matrix = A;
    }
    
    public void print(int a, int b){
        String format = "%" + a + "." + b + "f"; 
		for(int i=0; i < matrix.length;i++){
			for(int j=0; j < matrix[0].length; j++){
				System.out.printf(format, matrix[i][j]);
					}
			System.out.println();			
			}
	}
	
}
