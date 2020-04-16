public void solve(int testNumber, FastInput in, FastOutput out) {
    n = in.readInt();
    mat = new int[n + 1][n + 1][2];
    ans = new char[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            for (int k = 0; k < 2; k++) {
                mat[i][j][k] = in.readInt();
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (mat[i][j][0] != -1) {
                continue;
            }
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (check(ni, nj) && mat[ni][nj][0] == -1) {
                    ans[i][j] = get(i, j, ni, nj);
                    break;
                }
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (mat[i][j][0] == i && mat[i][j][1] == j) {
                dfs(i, j, i, j);
            }
        }
    }
    debug.debug("ans", ans);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (ans[i][j] == 0) {
                out.println("INVALID");
                return;
            }
        }
    }
    out.println("VALID");
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            out.append(ans[i][j]);
        }
        out.println();
    }
}