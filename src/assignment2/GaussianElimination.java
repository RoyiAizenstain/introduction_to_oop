package assignment2;

public class GaussianElimination {
    public static void gaussianElimination(double[][] matrix) {
        /*
         * Perform Gaussian elimination on the input matrix
         * @param matrix input matrix
         */
        int h = 0;
        int k = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        while (h < m && k < n) {
            // Find the k-th pivot
            int i_max = h;
            for (int i = h + 1; i < m; i++) {
                if (Math.abs(matrix[i][k]) > Math.abs(matrix[i_max][k])) {
                    i_max = i;
                }
            }

            if (matrix[i_max][k] == 0) {
                // No pivot in this column, pass to next column
                k++;
            } else {
                // Swap rows h and i_max
                double[] temp = matrix[h];
                matrix[h] = matrix[i_max];
                matrix[i_max] = temp;

                // Do for all rows below pivot
                for (int i = h + 1; i < m; i++) {
                    double f = matrix[i][k] / matrix[h][k];

                    // Fill with zeros the lower part of pivot column
                    matrix[i][k] = 0;

                    // Do for all remaining elements in current row
                    for (int j = k + 1; j < n; j++) {
                        matrix[i][j] -= matrix[h][j] * f;
                    }
                }

                // Increase pivot row and column
                h++;
                k++;
            }
        }
    }
}