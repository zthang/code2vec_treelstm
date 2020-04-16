static long[][] arl(int n, int m) throws IOException {
    long[][] ar = new long[n][m];
    for (int x = 0; x < n; x++) {
        st = new StringTokenizer(br.readLine());
        for (int y = 0; y < m; y++) ar[x][y] = Long.parseLong(st.nextToken());
    }
    return ar;
}