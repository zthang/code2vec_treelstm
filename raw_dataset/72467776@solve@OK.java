public void solve(int testNumber, FastReader s, PrintWriter w) {
    n = s.nextInt();
    p = new pair[n][n];
    vis = new boolean[n][n];
    ans = new char[n][n];
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) p[i][j] = new pair(s.nextInt() - 1, s.nextInt() - 1);
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) ans[i][j] = 'a';
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
        if (vis[i][j])
            continue;
        if (p[i][j].x == i && p[i][j].y == j) {
            par = p[i][j];
            ans[i][j] = 'X';
            dfs(p[i][j].x, p[i][j].y);
        } else if (p[i][j].x == -2) {
            pair cur = new pair(i, j);
            par = p[i][j];
            if (cur.x + 1 < n && p[cur.x + 1][cur.y].equals(par)) {
                ans[i][j] = 'D';
                dfs(i, j);
            } else if (cur.x - 1 >= 0 && !vis[cur.x - 1][cur.y] && p[cur.x - 1][cur.y].equals(par)) {
                ans[i][j] = 'U';
                dfs(i, j);
            } else if (cur.y + 1 < n && !vis[cur.x][cur.y + 1] && p[cur.x][cur.y + 1].equals(par)) {
                ans[i][j] = 'R';
                dfs(i, j);
            } else if (cur.y - 1 >= 0 && !vis[cur.x][cur.y - 1] && p[cur.x][cur.y - 1].equals(par)) {
                ans[i][j] = 'L';
                dfs(i, j);
            } else {
                w.println("INVALID");
                return;
            }
        }
    }
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (ans[i][j] == 'a') {
        w.println("INVALID");
        return;
    }
    w.println("VALID");
    for (char[] c : ans) w.println(c);
}