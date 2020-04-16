void work() {
    n = ni();
    ret = new char[n][n];
    for (char[] chs : ret) {
        Arrays.fill(chs, 'N');
    }
    A = new int[n][n][];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            A[i][j] = new int[] { in.nextInt() - 1, in.nextInt() - 1 };
        }
    }
    boolean[][] vis = new boolean[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (A[i][j][0] == i && A[i][j][1] == j) {
                ret[i][j] = 'X';
                dfs1(i, j, i, j, vis);
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (A[i][j][0] != -2 && !vis[i][j]) {
                out.println("INVALID");
                return;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (A[i][j][0] == -2) {
                boolean f = false;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dir[k][0], nj = j + dir[k][1];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= n || A[ni][nj][0] != -2)
                        continue;
                    f = true;
                }
                if (!f) {
                    out.println("INVALID");
                    return;
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!vis[i][j]) {
                dfs2(i, j, vis);
            }
        }
    }
    out.println("VALID");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            out.print(ret[i][j]);
        }
        out.println();
    }
}