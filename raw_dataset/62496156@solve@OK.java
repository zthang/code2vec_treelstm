static void solve() {
    n = in.nextInt();
    c = new long[4][n + 1];
    for (int i = 1; i <= n; i++) c[1][i] = in.nextInt();
    for (int i = 1; i <= n; i++) c[2][i] = in.nextInt();
    for (int i = 1; i <= n; i++) c[3][i] = in.nextInt();
    g = new ArrayList[n + 1];
    Arrays.setAll(g, i -> new ArrayList<>());
    for (int i = 0; i < n - 1; i++) {
        int v = in.nextInt();
        int u = in.nextInt();
        g[v].add(u);
        g[u].add(v);
    }
    for (int v = 1; v <= n; v++) {
        if (g[v].size() > 2) {
            out.println(-1);
            return;
        }
    }
    int v = 1;
    for (; v <= n; v++) {
        if (g[v].size() == 1)
            break;
    }
    int[] vs = new int[n];
    int pre = v;
    int cur = g[v].get(0);
    vs[0] = pre;
    vs[1] = cur;
    for (int i = 2; i < n; i++) {
        int nxt;
        if (g[cur].get(0) != pre)
            nxt = g[cur].get(0);
        else
            nxt = g[cur].get(1);
        pre = cur;
        cur = nxt;
        vs[i] = cur;
    }
    b = new int[4][4][n + 1];
    long sum = Long.MAX_VALUE;
    int I = 0, J = 0;
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            if (i == j)
                continue;
            b[i][j][vs[0]] = i;
            b[i][j][vs[1]] = j;
            long sum1 = c[i][vs[0]] + c[j][vs[1]];
            for (int k = 2; k < n; k++) {
                b[i][j][vs[k]] = 6 - b[i][j][vs[k - 1]] - b[i][j][vs[k - 2]];
                sum1 += c[b[i][j][vs[k]]][vs[k]];
            }
            if (sum1 < sum) {
                sum = sum1;
                I = i;
                J = j;
            }
        }
    }
    out.println(sum);
    for (int i = 1; i <= n; i++) {
        out.print(b[I][J][i] + " ");
    }
    out.println();
}