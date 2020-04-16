public double[][] next2DDoubleArray(int N, int M) {
    double[][] ret = new double[N][];
    for (int i = 0; i < N; i++) ret[i] = this.nextDoubleArray(M);
    return ret;
}