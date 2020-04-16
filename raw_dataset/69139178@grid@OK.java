char[][] grid(int r, int c) {
    char[][] res = new char[r][c];
    for (int i = 0; i < r; i++) {
        char[] l = next().toCharArray();
        for (int j = 0; j < c; j++) {
            res[i][j] = l[j];
        }
    }
    return res;
}