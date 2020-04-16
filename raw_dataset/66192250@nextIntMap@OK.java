public int[][] nextIntMap(int n, int m) {
    int[][] map = new int[n][m];
    for (int i = 0; i < n; i++) {
        map[i] = nextIntArray(m);
    }
    return map;
}