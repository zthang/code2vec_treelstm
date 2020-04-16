public void run() {
    FastReader sc = new FastReader();
    n = sc.nextInt();
    p = new Point[n][n];
    vis = new boolean[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int x = sc.nextInt(), y = sc.nextInt();
            if (x == -1) {
                p[i][j] = new Point(-1, -1);
            } else {
                p[i][j] = new Point(x - 1, y - 1);
            }
        }
    }
    ans = new char[n][n];
    for (char[] ar : ans) Arrays.fill(ar, '-');
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!vis[i][j] && p[i][j].equals(new Point(-1, -1))) {
                if (p[i][j].equals(new Point(-1, -1)) && i + 1 < n && p[i + 1][j].equals(new Point(-1, -1))) {
                    ans[i][j] = 'D';
                    vis[i][j] = true;
                    ans[i + 1][j] = 'U';
                    vis[i + 1][j] = true;
                } else if (j + 1 < n && p[i][j].equals(new Point(-1, -1)) && p[i][j + 1].equals(new Point(-1, -1))) {
                    ans[i][j] = 'R';
                    ans[i][j + 1] = 'L';
                    vis[i][j] = true;
                    vis[i][j + 1] = true;
                } else if (i - 1 >= 0 && p[i - 1][j].equals(new Point(-1, -1))) {
                    vis[i - 1][j] = true;
                    vis[i][j] = true;
                    ans[i][j] = 'U';
                    ans[i - 1][j] = 'D';
                } else if (j - 1 >= 0 && p[i][j - 1].equals(new Point(-1, -1))) {
                    vis[i][j - 1] = true;
                    vis[i][j] = true;
                    ans[i][j - 1] = 'R';
                    ans[i][j] = 'L';
                } else {
                    System.out.println("INVALID");
                    return;
                }
            }
        // System.out.print(ans[i][j]);
        }
    // System.out.println();
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!vis[i][j]) {
                if (!p[p[i][j].x][p[i][j].y].equals(p[i][j])) {
                    System.out.println("INVALID");
                    return;
                } else if (vis[p[i][j].x][p[i][j].y]) {
                    System.out.println("INVALID");
                    return;
                } else {
                    tmp = p[i][j];
                    if (!dfs(p[i][j].x, p[i][j].y, 'X')) {
                        // System.out.println(p[i][j]);
                        System.out.println("INVALID");
                        return;
                    }
                }
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    sb.append("VALID\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            sb.append(ans[i][j]);
        }
        sb.append("\n");
    }
    System.out.print(sb);
}