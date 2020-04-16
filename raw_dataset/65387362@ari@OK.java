static int[][] ari(int n, int m) throws IOException {
    int[][] ar = new int[n][m];
    for (int x = 0; x < n; x++) {
        st = new StringTokenizer(br.readLine());
        for (int y = 0; y < m; y++) ar[x][y] = Integer.parseInt(st.nextToken());
    }
    return ar;
}