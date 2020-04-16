public int[] readIntArray(int n) {
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = nextInt();
    }
    return x;
}