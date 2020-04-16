public void solve(InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    costs = new long[3][n];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < n; j++) {
            costs[i][j] = sc.nextLong();
        }
    }
    tree = new ArrayList[n];
    for (int i = 0; i < n; i++) tree[i] = new ArrayList();
    for (int i = 1; i <= n - 1; i++) {
        int src = sc.nextInt() - 1;
        int to = sc.nextInt() - 1;
        tree[src].add(to);
        tree[to].add(src);
        if (tree[src].size() >= 3) {
            out.println(-1);
            return;
        }
        if (tree[to].size() >= 3) {
            out.println(-1);
            return;
        }
    }
    first = 0;
    visited = new boolean[n];
    Arrays.fill(visited, false);
    for (int i = 0; i < n; i++) {
        if (tree[i].size() == 1) {
            first = i;
            break;
        }
    }
    sec = tree[first].get(0);
    for (int i : tree[sec]) {
        if (i != first) {
            third = i;
            break;
        }
    }
    tmp = third;
    visited[first] = true;
    visited[sec] = true;
    parent = new int[n];
    parent[sec] = first;
    // out.println(first + " " + sec + " " + third);
    parent(tmp);
    // out.println(Arrays.toString(parent));
    Arrays.fill(visited, false);
    visited[first] = true;
    visited[sec] = true;
    tmp = third;
    ans12[first] = 1;
    ans12[sec] = 2;
    // out.println(ans12[0]);
    dfs12(tmp);
    // visited[first] = true;
    // visited[sec] = true;
    // for(int i = 0; i < n; i++) {
    // out.print(ans12[i] + " ");
    // }
    // out.println();
    Arrays.fill(visited, false);
    tmp = third;
    ans21[first] = 2;
    ans21[sec] = 1;
    visited[first] = true;
    visited[sec] = true;
    dfs21(tmp);
    Arrays.fill(visited, false);
    tmp = third;
    ans13[first] = 1;
    ans13[sec] = 3;
    visited[first] = true;
    visited[sec] = true;
    dfs13(tmp);
    Arrays.fill(visited, false);
    tmp = third;
    ans31[first] = 3;
    ans31[sec] = 1;
    visited[first] = true;
    visited[sec] = true;
    dfs31(tmp);
    Arrays.fill(visited, false);
    tmp = third;
    ans23[first] = 2;
    ans23[sec] = 3;
    visited[first] = true;
    visited[sec] = true;
    dfs23(tmp);
    Arrays.fill(visited, false);
    tmp = third;
    ans32[first] = 3;
    ans32[sec] = 2;
    visited[first] = true;
    visited[sec] = true;
    dfs32(tmp);
    // out.println(first + " " + sec + " " + third);
    // for(int i = 0; i < n; i++) out.print(ans12[i] + " ");
    // out.println();
    // for(int i = 0; i < n; i++) out.print(parent[i] + " ");
    // out.println();
    long tmpcost = 0;
    for (int i = 0; i < n; i++) {
        tmpcost += costs[ans12[i] - 1][i];
    }
    if (tmpcost < cost) {
        cost = tmpcost;
        ans = ans12;
    }
    tmpcost = 0;
    for (int i = 0; i < n; i++) {
        tmpcost += costs[ans21[i] - 1][i];
    }
    if (tmpcost < cost) {
        cost = tmpcost;
        ans = ans21;
    }
    tmpcost = 0;
    for (int i = 0; i < n; i++) {
        tmpcost += costs[ans23[i] - 1][i];
    }
    if (tmpcost < cost) {
        cost = tmpcost;
        ans = ans23;
    }
    tmpcost = 0;
    for (int i = 0; i < n; i++) {
        tmpcost += costs[ans32[i] - 1][i];
    }
    if (tmpcost < cost) {
        cost = tmpcost;
        ans = ans32;
    }
    tmpcost = 0;
    for (int i = 0; i < n; i++) {
        tmpcost += costs[ans13[i] - 1][i];
    }
    if (tmpcost < cost) {
        cost = tmpcost;
        ans = ans13;
    }
    tmpcost = 0;
    for (int i = 0; i < n; i++) {
        tmpcost += costs[ans31[i] - 1][i];
    }
    if (tmpcost < cost) {
        cost = tmpcost;
        ans = ans31;
    }
    out.println(cost);
    for (int i = 0; i < n; i++) out.print(ans[i] + " ");
    out.println();
}