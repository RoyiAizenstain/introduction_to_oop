package assignment2;

public class GaussianElimination {
    public static void gaussianElimination(double[][] matrix) {
        /*
         * Perform Gaussian elimination on the input matrix
         * @param matrix input matrix
         */
        int h = 1;
        int k = 1;

        int m = matrix.length;
        int n = matrix[0].length;

        while (h <= m && k <= n) {
            // Find the k-th pivot
            int i_max = h - 1;
            for (int i = h; i < m; i++) {
                if (Math.abs(matrix[i][k - 1]) > Math.abs(matrix[i_max][k - 1])) {
                    i_max = i;
                }
            }

            if (matrix[i_max][k - 1] == 0) {
                // No pivot in this column, pass to next column
                k++;
            } else {
                // Swap rows h and i_max
                double[] temp = matrix[h - 1];
                matrix[h - 1] = matrix[i_max];
                matrix[i_max] = temp;

                // Do for all rows below pivot
                for (int i = h; i < m; i++) {
                    double f = matrix[i][k - 1] / matrix[h - 1][k - 1];

                    // Fill with zeros the lower part of pivot column
                    matrix[i][k - 1] = 0;

                    // Do for all remaining elements in current row
                    for (int j = k; j < n; j++) {
                        matrix[i][j] -= matrix[h - 1][j] * f;
                    }
                }

                // Increase pivot row and column
                h++;
                k++;
            }
        }
    }
}