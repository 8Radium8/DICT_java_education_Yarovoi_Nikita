package MatrixProcessing;
import java.util.Scanner;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить матрицу\n2. Умножить на константу\n3. Умножить\n4. Транспортировать матрицу\n5. Вычислить\n6. Обратная матрица\n0. Выход");
            System.out.print("Ввод: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    multiplyByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 4:
                    transposeMatrix();
                    break;
                case 5:
                    calculateDeterminant();
                    break;
                case 6:
                    inverseMatrix();
                    break;
                case 0:
                    System.out.println("Выход из программы!");
                    System.exit(0);
                default:
                    System.out.println("Неправильный выбор. Повторите попытку.");
            }
        }
    }

    private static void inverseMatrix() {
        int[][] matrix = readMatrix();

        if (isSquare(matrix)) {
            int determinant = calculateDeterminant(matrix);
            if (determinant != 0) {
                double[][] inverse = calculateInverse(matrix);
                System.out.println("Результат:");
                printMatrix(inverse);
            } else {
                System.out.println("Эта матрица не имеет обратной");
            }
        } else {
            System.out.println("Ошибка.");
        }
    }

    private static double[][] calculateInverse(int[][] matrix) {
        int n = matrix.length;
        int[][] augmentedMatrix = new int[n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
            }
            augmentedMatrix[i][i + n] = 1;
        }

        augmentedMatrix = rowReduce(augmentedMatrix);

        double[][] inverse = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = (double) augmentedMatrix[i][j + n];
            }
        }

        return inverse;
    }

    private static int[][] rowReduce(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int i = 0; i < rowCount; i++) {
            int pivotColumn = -1;
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] != 0) {
                    pivotColumn = j;
                    break;
                }
            }

            if (pivotColumn != -1) {
                int pivotValue = matrix[i][pivotColumn];
                for (int j = 0; j < colCount; j++) {
                    matrix[i][j] /= pivotValue;
                }

                for (int k = 0; k < rowCount; k++) {
                    if (k != i) {
                        int factor = matrix[k][pivotColumn];
                        for (int j = 0; j < colCount; j++) {
                            matrix[k][j] -= factor * matrix[i][j];
                        }
                    }
                }
            }
        }

        return matrix;
    }

    private static void calculateDeterminant() {
        int[][] matrix = readMatrix();

        if (isSquare(matrix)) {
            int determinant = calculateDeterminant(matrix);
            System.out.println("Результат: " + determinant);
        } else {
            System.out.println("Ошибка.");
        }
    }

    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        for (int i = 0; i < n; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(getSubmatrix(matrix, 0, i));
        }

        return determinant;
    }

    private static int[][] getSubmatrix(int[][] matrix, int rowToRemove, int colToRemove) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        int[][] submatrix = new int[rows][cols];

        for (int i = 0, newRow = 0; i < matrix.length; i++) {
            if (i == rowToRemove) {
                continue;
            }

            for (int j = 0, newCol = 0; j < matrix[i].length; j++) {
                if (j == colToRemove) {
                    continue;
                }

                submatrix[newRow][newCol] = matrix[i][j];
                newCol++;
            }

            newRow++;
        }

        return submatrix;
    }

    private static boolean isSquare(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    private static int[][] readMatrix() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Количество слобцов: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Значение матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void addMatrices() {
    }

    private static void multiplyByConstant() {
    }

    private static void multiplyMatrices() {
    }

    private static void transposeMatrix() {
    }
}
