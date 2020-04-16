double[] nda(int n) throws IOException {
    double[] a = new double[n];
    for (int i = 0; i < n; i++) a[i] = nd();
    return a;
}