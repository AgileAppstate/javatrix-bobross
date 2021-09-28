public class Matrix {
    double[][] matrix;

    private Matrix(double[][] A){
        matrix = A;
    }
    
    public void print(int a, int b){
		for(int i=0; i<a;i++){
			for(int j=0; j<b; j++){
				System.out.print(matrix[i][j]+ " ");
					}
			System.out.println();			
			}
	}
	
}
