void solve() {
    int n = ni();
    for (int i = 0; i < 1005; i++) {
        for (int j = 0; j < 1005; j++) {
            s[i][j] = '\0';
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            to[i][j][0] = ni();
            to[i][j][1] = ni();
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (to[i][j][0] == i && to[i][j][1] == j) {
                s[i][j] = 'X';
                dfs(i, j, i, j);
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (to[i][j][0] == -1) {
                if (to[i][j + 1][0] == -1) {
                    s[i][j] = 'R';
                } else if (to[i][j - 1][0] == -1) {
                    s[i][j] = 'L';
                } else if (to[i + 1][j][0] == -1) {
                    s[i][j] = 'D';
                } else if (to[i - 1][j][0] == -1) {
                    s[i][j] = 'U';
                } else {
                    out.println("INVALID");
                    return;
                }
            } else if (s[i][j] == '\0') {
                out.println("INVALID");
                return;
            }
        }
    }
    out.println("VALID");
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            out.print(s[i][j]);
        }
        out.println();
    }
}