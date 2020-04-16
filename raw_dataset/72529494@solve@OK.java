public void solve(InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    for (char[] cr : mat) Arrays.fill(cr, '0');
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            x[i][j] = sc.nextInt();
            y[i][j] = sc.nextInt();
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (x[i][j] == -1) {
                boolean res = mat[i][j] != '0';
                if (!res) {
                    res = connect(i, j, i + 1, j, 'D', 'U');
                }
                if (!res) {
                    res = connect(i, j, i, j + 1, 'R', 'L');
                }
                if (!res) {
                    res = connect(i, j, i - 1, j, 'U', 'D');
                }
                if (!res) {
                    res = connect(i, j, i, j - 1, 'L', 'R');
                }
                if (!res) {
                    out.println("INVALID");
                    return;
                }
            } else if (x[i][j] == i && y[i][j] == j) {
                dfs(i, j, 'X');
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (mat[i][j] == '0') {
                out.println("INVALID");
                return;
            }
        }
    }
    out.println("VALID");
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            out.print(mat[i][j]);
        }
        out.println();
    }
}