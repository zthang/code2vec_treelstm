public void solve() {
    int n = sc.ni();
    Pair[][] arr = new Pair[n][n];
    char[][] ans = new char[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int x = sc.ni() - 1;
            int y = sc.ni() - 1;
            arr[i][j] = new Pair(x, y);
            ans[i][j] = '@';
            if (x != -2)
                ans[x][y] = 'X';
        }
    }
    int res = 0;
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (ans[i][j] != '@')
        if (arr[i][j].a != i || arr[i][j].b != j)
            res = -1;
    int[][] visit = new int[n][n];
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if ((ans[i][j] == 'X'))
        dfs(i, j, arr, ans, i, j, 'X');
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (arr[i][j].a == -2) {
                int hold = 0;
                int tmp = i;
                int tmp1 = j;
                tmp++;
                if (f(tmp, tmp1, arr.length) && (arr[tmp][tmp1].a == -2)) {
                    hold++;
                    ans[i][j] = 'D';
                    continue;
                }
                tmp--;
                tmp--;
                if (f(tmp, tmp1, arr.length) && (arr[tmp][tmp1].a == -2)) {
                    hold++;
                    ans[i][j] = 'U';
                    continue;
                }
                tmp++;
                tmp1++;
                if (f(tmp, tmp1, arr.length) && (arr[tmp][tmp1].a == -2)) {
                    hold++;
                    ans[i][j] = 'R';
                    continue;
                }
                tmp1--;
                tmp1--;
                if (f(tmp, tmp1, arr.length) && (arr[tmp][tmp1].a == -2)) {
                    hold++;
                    ans[i][j] = 'L';
                    continue;
                }
                tmp1++;
                if (hold == 0)
                    res = -1;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            // pw.print(ans[i][j]);
            if (ans[i][j] == '@')
                res = -1;
        }
    // pw.println("");
    }
    if (res == -1)
        pw.println("INVALID");
    else {
        pw.println("VALID");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(ans[i][j]);
                if (ans[i][j] == '@')
                    res = -1;
            }
            pw.println("");
        }
    }
}