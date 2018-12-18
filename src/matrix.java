
import java.util.Scanner;
public class matrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean stat = true;
        int option;

        while(stat){
            System.out.println("Hello this is a simple matrix calculator \n "
                    + "To Create a new matrix problem enter 1 and to exit the calculator enter 2");
            option = in.nextInt();
            switch(option){
                case 1:
                    stat = createProblem(option);
                    break;
                case 2:
                    stat = false;
                    break;
                default:
                    stat = false;
                    break;
            }
        }
        System.out.println("Calculator now terminated");
    }
    public static boolean createProblem(int i){
        Scanner in = new Scanner(System.in);
        boolean condition;
        int contStat;
        boolean statusC;
        int frows;
        int fcolumns;
        int srows;
        int scolumns;
        int[][] matrix1;
        int[][] matrix2;
        int[][] matrix1Values;
        int[][] matrix2Values;
        System.out.println("Enter number of rows in first matrix");
        frows = in.nextInt();
        String operator;
        System.out.println("Enter number of columns in first matrix");
        fcolumns = in.nextInt();
        System.out.println("Enter number of rows in second matrix");
        srows = in.nextInt();
        System.out.println("Enter number of columns in second matrix");
        scolumns = in.nextInt();
        matrix1 = createMatrix(frows, fcolumns);
        matrix2 = createMatrix(srows, scolumns);
        matrix1Values = setMatrixValues(matrix1,"First");
        matrix2Values = setMatrixValues(matrix2, "Second");
        statusC = true;
        while(statusC){
            System.out.println("Select matrix operation, \n type in + for addition, - for subtraction or * for multiplication:");
            operator = in.next();
            statusC = performOperation(operator, matrix1Values, matrix2Values);
        }
        System.out.println("Type 1 if you would like to continue using the calcultor,\n type 2 if you would like to exit");
        contStat = in.nextInt();
        switch(contStat){
            case 1:
                condition = true;
                break;
            case 2:
                condition = false;
                break;
            default:
                condition = false;
                break;
        }
        return condition;

    }

    public static boolean performOperation(String operator, int[][] matrix1, int[][] matrix2){
        Scanner in = new Scanner(System.in);
        int optSelected;
        boolean status = false;
        switch(operator){

            case "+":
                addMatrices(matrix1, matrix2);
                break;

            default:
                System.out.println("Operator not valid");
                break;
        }
        System.out.println("If you would like to perform additional operations on the two matrices used"+
                " Type 1, or if you what to use a different pair of matrices to perform operations with type 2"+
                "To exit type 3");
        optSelected = in.nextInt();
        switch(optSelected){
            case 1:
                status = true;
                break;
            case 2:
                status = false;
                break;
            case 3:
                status = false;
                break;
        }
        return status;
    }
    public static int[][] setMatrixValues(int[][] matrix, String label){
        Scanner in = new Scanner(System.in);
        int dataEntered;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j< columns; j++){
                System.out.println("Enter value of "+label+" matrix at row: "+i+" and column:"+j+" :");
                dataEntered = in.nextInt();
                matrix[i][j] = dataEntered;
            }
        }
        return matrix;
    }
    public static int[][] createMatrix(int numRows, int numColumns){
        int[][] matrix = new int[numRows][numColumns];
        return matrix;
    }

    public static void addMatrices(int[][] matrix1, int[][] matrix2){
        boolean status = checkIfValidAddSub(matrix1, matrix2);
        if(status == true){
            for(int i = 0; i < matrix1.length; i++){
                for(int j = 0; j < matrix1[0].length; j++){
                    int charM1 = matrix1[i][j];
                    int charM2 = matrix2[i][j];
                    int resultant = charM1 + charM2;
                    System.out.print(resultant+" ");
                }
                System.out.print("\n");
            }
        }else{
            System.out.println("In order to add or subtract matrices they both must have the same number of rows \n and the same number of columns");
        }
    }


    public static boolean checkIfValidAddSub(int[][] matrix1, int[][] matrix2){
        boolean status;
        int numRows1 = matrix1.length;
        int numColumns1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numColumns2 = matrix2[0].length;
        if(numRows1 == numRows2 && numColumns1 == numColumns2){
            status = true;
        }else{
            status = false;
        }
        return status;
    }
    public static boolean checkIfValidMult(int[][] matrix1, int[][] matrix2){
        boolean status;
        int columns = matrix1[0].length;
        int rows = matrix2.length;
        if( columns == rows){
            status = true;
        }else{
            status = false;
        }
        return status;
    }

}