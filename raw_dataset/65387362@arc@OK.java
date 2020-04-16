static char[][] arc(int n, int m) throws IOException {
    char[][] ar = new char[n][m];
    for (int x = 0; x < n; x++) {
        String s = br.readLine();
        for (int y = 0; y < m; y++) ar[x][y] = s.charAt(y);
    }
    return ar;
}