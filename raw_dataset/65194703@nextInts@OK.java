int[][] nextInts(int count, int n) {
    int[][] res = new int[n][count];
    for (int i = 0; i < count; ++i) {
        for (int j = 0; j < n; j++) {
            res[j][i] = in.nextInt();
        }
    }
    return res;
}