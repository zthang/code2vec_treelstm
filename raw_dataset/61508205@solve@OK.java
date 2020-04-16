public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    g = new HashSet[n + 1];
    for (int i = 1; i <= n; i++) g[i] = new HashSet<>();
    int[][] ee = new int[m][2];
    visited = new boolean[n + 1];
    for (int i = 0; i < m; i++) {
        int a = in.scanInt();
        int b = in.scanInt();
        g[a].add(b);
        g[b].add(a);
        ee[i] = new int[] { a, b };
    }
    dfs(1);
    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            out.println(-1);
            return;
        }
    }
    int[] ans = new int[n + 1];
    Arrays.fill(ans, -1);
    for (int k : g[1]) ans[k] = 4;
    for (int i = 1; i <= n; i++) if (ans[i] == -1)
        ans[i] = 1;
    int index = -1;
    for (int i = 1; i <= n; i++) {
        if (ans[i] == 4) {
            ans[i] = 2;
            index = i;
            break;
        }
    }
    if (index == -1) {
        out.println(-1);
        return;
    }
    for (int k : g[index]) if (ans[k] == 4)
        ans[k] = 3;
    for (int i = 1; i <= n; i++) if (ans[i] == 4)
        ans[i] = 2;
    boolean check = true;
    for (int i = 1; i <= n; i++) {
        if (ans[i] == -1)
            check = false;
        if (ans[i] == 4)
            check = false;
        if (ans[i] == 1 || ans[i] == 2 || ans[i] == 3) {
        } else {
            check = false;
        }
    }
    long o1 = 0;
    long o2 = 0;
    long o3 = 0;
    for (int i = 1; i <= n; i++) {
        if (ans[i] == 1)
            o1++;
        else if (ans[i] == 2)
            o2++;
        else if (ans[i] == 3)
            o3++;
    }
    long c23 = 0;
    long c12 = 0;
    long c13 = 0;
    if (o1 == 0 || o2 == 0 || o3 == 0)
        check = false;
    for (int i = 0; i < m; i++) {
        if (ans[ee[i][0]] == ans[ee[i][1]])
            check = false;
        if (ans[ee[i][0]] == 2 && ans[ee[i][1]] == 3)
            c23++;
        if (ans[ee[i][0]] == 3 && ans[ee[i][1]] == 2)
            c23++;
        if (ans[ee[i][0]] == 1 && ans[ee[i][1]] == 2)
            c12++;
        if (ans[ee[i][0]] == 2 && ans[ee[i][1]] == 1)
            c12++;
        if (ans[ee[i][0]] == 1 && ans[ee[i][1]] == 3)
            c13++;
        if (ans[ee[i][0]] == 3 && ans[ee[i][1]] == 1)
            c13++;
    }
    if (c23 == (o2 * o3)) {
    } else {
        check = false;
    }
    if (c13 == (o1 * o3)) {
    } else {
        check = false;
    }
    if (c12 == (o1 * o2)) {
    } else {
        check = false;
    }
    if (check) {
        for (int i = 1; i <= n; i++) {
            out.print(ans[i] + " ");
        }
    } else {
        out.println(-1);
    }
}