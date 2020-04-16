double[] nextDoubleArr(int n) {
    double[] arr = new double[n];
    for (int i = 0; i < n; i++) {
        arr[i] = nextDouble();
    }
    return arr;
}