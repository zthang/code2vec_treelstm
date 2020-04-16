static void solve() throws IOException {
    n = nextInt();
    cost = new long[4][n + 1];
    degree = new int[n + 1];
    endpoint = 1;
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= n; j++) cost[i][j] = nextLong();
    }
    list = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
    boolean flag = true;
    for (int i = 1; i < n; i++) {
        int u = nextInt();
        int v = nextInt();
        degree[u]++;
        degree[v]++;
        list.get(u).add(v);
        list.get(v).add(u);
        if (degree[u] > 2 || degree[v] > 2) {
            flag = false;
            break;
        }
    }
    for (; degree[endpoint] != 1; endpoint++) ;
    if (flag) {
        long mincost = (long) (1e18);
        int[] ans = new int[n + 1];
        for (int color = 1; color <= 3; color++) {
            for (int color2 = 1; color2 <= 3; color2++) {
                if (color != color2) {
                    visited = new boolean[n + 1];
                    mincolor = new int[n + 1];
                    long x = dfs(endpoint, color2, color);
                    if (x < mincost) {
                        mincost = x;
                        ans = mincolor;
                    }
                }
            }
        }
        out.println(mincost);
        for (int i = 1; i <= n; i++) out.print(ans[i] + " ");
    } else
        out.println(-1);
}