public int[] nextIntArray1Index(int n) {
    int[] res = new int[n + 1];
    for (int i = 0; i < n; i++) {
        res[i + 1] = nextInt();
    }
    return res;
}