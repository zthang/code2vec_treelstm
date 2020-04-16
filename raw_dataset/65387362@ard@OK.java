static double[][] ard(int n, int m) throws IOException {
    double[][] ar = new double[n][m];
    for (int x = 0; x < n; x++) {
        st = new StringTokenizer(br.readLine());
        for (int y = 0; y < m; y++) ar[x][y] = Double.parseDouble(st.nextToken());
    }
    return ar;
}