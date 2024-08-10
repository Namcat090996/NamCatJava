import java.util.Random;

public class Matrix {

    //Declare the quantity of columns and rows in the array
    int n, m;

    //Declare an array
    int[][] matrixA, matrixB;

    /**
     * Function to assign columns and rows to array
     * @param m
     * @param n
     */
    public Matrix(int m, int n)
    {
        this.n = n;
        this.m = m;

        matrixA = new int[m][n];
        matrixB = new int[n][m];
        randomValue();
    }

    /**
     * Function to create the random value for elements in the array
     */
    public void randomValue()
    {
        Random rd = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = rd.nextInt(10);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = rd.nextInt(10);
            }
        }

    }

    /**
     * Function to print the array
     */
    public void printMatrix()
    {
        System.out.println("Ma trận A gồm các phần tử:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("matrixA[%d][%d] = %d\t", i, j, matrixA[i][j]);
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

        System.out.println("Ma trận B gồm các phần tử:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("matrixB[%d][%d] = %d\t", i, j, matrixB[i][j]);
            }
            System.out.println();
        }

        //System.out.println(matrixA.length);//Số hàng ma trận A
        //System.out.println(matrixA[1].length);//Số cột ma trận A
    }

    /**
     * Function to sum 02 matrix
     */
    //public void sumMatrix()
    {
        System.out.println("--------------------------------");
        System.out.println("Tổng của ma trận A và ma trận B là: ");
        int[][] matrixC = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                System.out.printf("matrixC[%d][%d] = %d\t", i, j, matrixC[i][j]);
            }
            System.out.println();
        }
    }

    public void multiplyMatrix()
    {
        System.out.println("--------------------------------");
        System.out.println("Tích của ma trận A và ma trận B là: ");
        int[][] matrixC = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    matrixC[i][j] += matrixA[i][k]*matrixB[k][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("matrixC[%d][%d] = %d\t", i, j, matrixC[i][j]);
            }
            System.out.println();
        }
    }





}
