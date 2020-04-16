public char[][] nextCharArray(int n) {
    char[][] matrix = new char[n][];
    for (int i = 0; i < n; i++) {
        matrix[i] = next().toCharArray();
    }
    return matrix;
}