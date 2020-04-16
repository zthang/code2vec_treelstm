public double[] nextDoubleArray(int n) throws IOException {
    double[] ans = new double[n];
    for (int i = 0; i < n; i++) ans[i] = nextDouble();
    return ans;
}