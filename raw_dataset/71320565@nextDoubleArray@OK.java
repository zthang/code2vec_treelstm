public double[] nextDoubleArray(int N) {
    double[] ret = new double[N];
    for (int i = 0; i < N; i++) ret[i] = this.nextDouble();
    return ret;
}