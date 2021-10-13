import java.util.Scanner;

public class explorer {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("generate matrix with 1d input: 0");
            System.out.println("generate matrix with 2d input: 1");
            System.out.println("generate matrix with unchecked 2d input: 2");




            int input = scan.nextInt();
            switch (input) {
                case 0:
                    generate1d();
                    break;
                case 1:
                    generate2d();
                    break;

                case 2:
                    generate2dUnchecked();
                    break;



                default:
                    return;

            }

        }
    }

    public static Matrix generate1d(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter a comma seperated 1d matrix: ");
        String test = scan.nextLine();
        String delims = "[,]";
        int m;
        String[] strarray = test.split(delims);
        double[] doubarray = new double[strarray.length];
        for (int i = 0; i < strarray.length; i++){
            doubarray[i] = Double.parseDouble(strarray[i]);
        }
        System.out.print("Please Enter number of columns (len of 1d matrix must be evenly divisible by this number): ");
        test = scan.nextLine();
        m = Integer.parseInt(test);

        Matrix matrix = new Matrix(doubarray, m);
        matrix.print(3, 3);

        return matrix;

    }

    public static Matrix generate2d(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter a comma and bracket seperated 2d matrix ex [1,2,3] [4,5,6]: ");
        String test = scan.nextLine();
        String[] strarray = test.split("\\[");
        double[][] doubarray = new double[strarray.length][];
        String[] numarray;

        for (int i = 0; i < strarray.length; i++){
            strarray[i].replace("]", "");
            numarray = strarray[i].split(",");
            doubarray[i] = new double[numarray.length];
            for (int j = 0; j < doubarray[i].length; j++){
                doubarray[i][j] = Double.parseDouble(numarray[i]);
            }
        }


        Matrix matrix = new Matrix(doubarray);
        matrix.print(3, 3);
        return matrix;

    }

    public static Matrix generate2dUnchecked(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter a comma and bracket seperated 2d matrix ex [1,2,3] [4,5,6]: ");
        String test = scan.nextLine();
        int m;
        int n;
        String[] strarray = test.split("\\[");
        double[][] doubarray = new double[strarray.length][];
        String[] numarray;

        for (int i = 0; i < strarray.length; i++){
            strarray[i].replace("]", "");
            numarray = strarray[i].split(",");
            doubarray[i] = new double[numarray.length];
            for (int j = 0; j < doubarray[i].length; j++){
                doubarray[i][j] = Double.parseDouble(numarray[i]);
            }
        }

        System.out.print("Please Enter number of columns: ");
        test = scan.nextLine();
        m = Integer.parseInt(test);

        System.out.print("Please Enter number of rows: ");
        test = scan.nextLine();
        n = Integer.parseInt(test);

        Matrix matrix = new Matrix(doubarray, m, n);
        matrix.print(3, 3);
        return matrix;

    }

    public static Matrix genearateMatrix() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What would you like your inout matrix to be?");
        System.out.println("generate matrix with 1d input: 0");
        System.out.println("generate matrix with 2d input: 1");
        System.out.println("generate matrix with unchecked 2d input: 2");
        int input = scan.nextInt();
        switch (input) {
            case 0:
                return generate1d();
            case 1:
                return generate2d();

            case 2:
                return generate2dUnchecked();

            default:
                throw new RuntimeException("You didn't say the magic word!");
        }

    }

    public static void timesMatrix(){
        Matrix matrix1 = genearateMatrix();
        Matrix matrix2 = genearateMatrix();

        Matrix output = matrix1.times(matrix2);
        output.print(3,3);
    }

    public static void transposeMatrix(){
        Matrix matrix1 = genearateMatrix();
        Matrix matrix2 = genearateMatrix();

        Matrix output = matrix1.;
        output.print(3,3);
    }
}
