public static void dfs(int i, int j, int[][] mar, int n, int[][] a, int[][] b) {
    mar[i][j] = 1;
    for (int l = 0; l < 4; l++) {
        int u = i + dx[l];
        int v = j + dy[l];
        if (u >= 0 && u < n && v >= 0 && v < n) {
            // System.out.println(a[i][j]+" "+b[i][j]+" "+a[u][v]+" "+b[u][v]);
            if (mar[u][v] == 0 && a[i][j] == a[u][v] && b[i][j] == b[u][v]) {
                ans[u][v] = odir[l];
                dfs(u, v, mar, n, a, b);
            }
        }
    }
}