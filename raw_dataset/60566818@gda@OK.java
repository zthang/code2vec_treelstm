public double[] gda(int n, int start, int end) throws IOException {
    validate(n, start, end);
    double[] a = new double[n];
    for (int i = start; i < end; i++) {
        a[i] = nd();
    }
    return a;
}