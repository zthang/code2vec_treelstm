/**
 * Reads an array of double values.
 * @return
 * @throws IOException
 */
public double[] nextDoubleArray(int n) throws IOException {
    double[] arr = new double[n];
    for (int i = 0; i < n; i++) {
        arr[i] = nextDouble();
    }
    return arr;
}