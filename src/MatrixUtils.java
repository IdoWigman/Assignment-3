
public class MatrixUtils {

    // matrix is not null
    // prints the content of the matrix in a visual 2-dim representation
    public static void printMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix cannot be null");
        }

        String s = "";
        s += "[";

        for (int i = 0; i < matrix.getNumRows(); i++) {

            if (i > 0) {
                s += " ";
            }
            s += "[";

            for (int j = 0; j < matrix.getNumCols(); j++) {
                s += matrix.get(i, j);
                if (j < matrix.getNumCols() - 1) {
                    s += " ";
                }
            }

            s += "]";

            if (i < matrix.getNumRows() - 1) {
                s += "\n";
            }
        }

        s += "]";

        System.out.println(s);
    }
}
