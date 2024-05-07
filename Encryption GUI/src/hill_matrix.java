import java.util.Scanner;

public class hill_matrix {

    public static int[][] getKeyMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key:(2*2 matrix)");
        int[][] keyMatrix = new int[2][2];

        // loop for accepting key matrix from user
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Row "+i+" Column "+j+": ");
                keyMatrix[i][j] = sc.nextInt();
            }
        }
        return keyMatrix;
    }

    // checks the determinant of matrix, if 0 throws error
    public static void isValidMatrix(int[][] keyMatrix)
    {
        int det = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        if(det == 0) {
            throw new java.lang.Error("Invalid Matrix provided! [Determinant is Zero]");
        }
    }

// modular way of finding inverse of matrix
    public static int[][] reverseMatrix(int[][] keyMatrix)
    {
        int a = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]) % 26;
        int factor;
        int[][] reverseMatrix = new int[2][2];
        for(factor=1; factor < 26; factor++)
        {
            if((a * factor) % 26 == 1)
            {
                break;
            }
        }
        reverseMatrix[0][0] = keyMatrix[1][1]           * factor % 26;
        reverseMatrix[0][1] = (26 - keyMatrix[0][1])    * factor % 26;
        reverseMatrix[1][0] = (26 - keyMatrix[1][0])    * factor % 26;
        reverseMatrix[1][1] = keyMatrix[0][0]           * factor % 26;

        System.out.println("~~~\nReverse Matrix:");
        System.out.println(reverseMatrix[0][0]+"\t"+reverseMatrix[0][1]+"\n"+reverseMatrix[1][0]+"\t"+reverseMatrix[1][1]);
        return reverseMatrix;
    }


// checking if the inverse matrix is correct by multiplying to the original matrix
    public static void isValidReverseMatrix(int[][] keyMatrix, int[][] reverseMatrix) {
        int[][] matrixIden = new int[2][2];

        matrixIden[0][0] = (keyMatrix[0][0]*reverseMatrix[0][0] + keyMatrix[0][1] * reverseMatrix[1][0]) % 26;
        matrixIden[0][1] = (keyMatrix[0][0]*reverseMatrix[0][1] + keyMatrix[0][1] * reverseMatrix[1][1]) % 26;
        matrixIden[1][0] = (keyMatrix[1][0]*reverseMatrix[0][0] + keyMatrix[1][1] * reverseMatrix[1][0]) % 26;
        matrixIden[1][1] = (keyMatrix[1][0]*reverseMatrix[0][1] + keyMatrix[1][1] * reverseMatrix[1][1]) % 26;

        //System.out.println(matrixIden[0][0]+"\t"+matrixIden[0][1]+"\n"+matrixIden[1][0]+"\t"+matrixIden[1][1]+"\n");

       if(matrixIden[0][0] != 1 || matrixIden[0][1] != 0 || matrixIden[1][0] != 0 || matrixIden[1][1] != 1) {
           throw new java.lang.Error("Unable to compute Inverse matrix valid for Decryption");
        }
    }

    public static int[][] convertStringToIntMatrix(String inputString) {
        String[] elements = inputString.split(",");
        if (elements.length != 4) {
            throw new IllegalArgumentException("Input string should have 4 comma-separated integers for a 2x2 matrix");
        } else {
            int[][] matrix = new int[2][2];

            for(int i = 0; i < elements.length; ++i) {
                try {
                    matrix[i / 2][i % 2] = Integer.parseInt(elements[i]);
                } catch (NumberFormatException var5) {
                    throw new IllegalArgumentException("Input string contains non-numeric characters");
                }
            }

            return matrix;
        }
    }
}

