public int[] nextIntArrayDec(int n) {
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
        res[i] = nextInt() - 1;
    }
    return res;
}