public double[] nextDoubleArray(int n) {
    double[] res = new double[n];
    for (int i = 0; i < n; i++) {
        res[i] = nextDouble();
    }
    return res;
}