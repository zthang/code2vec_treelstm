void solve(int TC) throws Exception {
    int n = ni();
    int[][][] g = new int[n][n][2];
    char[][] ans = new char[n][n];
    Queue<Pos> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            g[i][j] = new int[] { ni() - 1, ni() - 1 };
            ans[i][j] = ' ';
            if (g[i][j][0] == i && g[i][j][1] == j) {
                ans[i][j] = 'X';
                q.add(new Pos(i, j));
            }
        }
    }
    char[] f = new char[] { 'D', 'U', 'R', 'L' };
    while (!q.isEmpty()) {
        Pos p = q.poll();
        int c = 0;
        for (int[] d : D) {
            int xx = p.x + d[0], yy = p.y + d[1];
            char ch = f[c];
            c++;
            if (Math.min(xx, yy) < 0 || Math.max(xx, yy) >= n || g[xx][yy][0] != g[p.x][p.y][0] || g[xx][yy][1] != g[p.x][p.y][1] || ans[xx][yy] != ' ')
                continue;
            ans[xx][yy] = ch;
            q.add(new Pos(xx, yy));
        }
    }
    boolean valid = true;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (g[i][j][0] == -2 && g[i][j][1] == -2) {
                int c = 0, cnt = 0;
                for (int[] d : D) {
                    int ii = i + d[0], jj = j + d[1];
                    char ch = f[cnt];
                    cnt++;
                    if (Math.min(ii, jj) < 0 || Math.max(ii, jj) >= n)
                        continue;
                    if (g[ii][jj][0] == -2 && g[ii][jj][1] == -2) {
                        ans[ii][jj] = ch;
                        c++;
                        ans[i][j] = op(ch);
                        break;
                    }
                }
                if (c == 0)
                    valid = false;
            }
        }
    }
    for (char[] cc : ans) for (char c : cc) valid &= c != ' ';
    if (!valid)
        pn("INVALID");
    else {
        pn("VALID");
        for (char[] cc : ans) {
            for (char c : cc) p(c);
            pn("");
        }
    }
}