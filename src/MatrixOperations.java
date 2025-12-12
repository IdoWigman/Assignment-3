public class MatrixOperations {
	
	// Task 3.9
    // 'm1' and 'm2' are not null. The number of columns of m1 equals the number of rows of m2.
    // Returns m1*m2
    public static Matrix multiply(Matrix m1, Matrix m2) {
        Matrix ans = null;
		// ---------------write your code BELOW this line only! ------------------
        if ((m1 == null) || (m2 == null) || (m1.getNumCols() != m2.getNumRows())) {
            throw new IllegalArgumentException("invalid input");
        }
        ans = new SimpleMatrix(m1.getNumRows(), m2.getNumCols());
        for(int i = 0; i < ans.getNumRows(); i++) {
            for(int j = 0; j < ans.getNumCols(); j++) {
                double sum = 0;
                for(int k = 0; k < m1.getNumCols(); k++) {
                    sum += m1.get(i, k) * m2.get(k, j);
                }
                ans.set(i, j, sum);
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

}
