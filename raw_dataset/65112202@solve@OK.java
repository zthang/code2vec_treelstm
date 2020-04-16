void solve() {
    int n = ni();
    int[][] color = na(3, n);
    List<Integer>[] edges = new List[n];
    for (int i = 0; i < n; i++) edges[i] = new ArrayList<Integer>();
    for (int i = 0; i < n - 1; i++) {
        int[] v = na(2);
        edges[v[0] - 1].add(v[1] - 1);
        edges[v[1] - 1].add(v[0] - 1);
    }
    id = new int[n];
    for (int i = 0; i < n; i++) {
        if (edges[i].size() > 2) {
            sb.append("-1");
            return;
        }
        if (edges[i].size() == 1)
            id[0] = i;
    }
    dfs(edges, 0, -1);
    // tr(id);
    long min = Long.MAX_VALUE / 2;
    int[] ans = null;
    int[] c = new int[3];
    for (c[0] = 0; c[0] < 3; c[0]++) for (c[1] = 0; c[1] < 3; c[1]++) {
        if (c[1] == c[0])
            continue;
        c[2] = 3 - c[0] - c[1];
        long sum = 0;
        for (int i = 0; i < n; i++) sum += color[c[i % 3]][id[i]];
        if (sum < min) {
            min = sum;
            ans = c.clone();
        }
    }
    sb.append(min).append(System.lineSeparator());
    int[] colors = new int[n];
    for (int i = 0; i < n; i++) colors[id[i]] = ans[i % 3] + 1;
    for (int i = 0; i < n; i++) sb.append(colors[i]).append(' ');
}