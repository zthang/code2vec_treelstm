void solve() {
    n = in.nextInt();
    graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    mas = new long[n][3];
    used = new boolean[n];
    for (int j = 0; j < 3; j++) for (int i = 0; i < n; i++) mas[i][j] = in.nextLong();
    for (int i = 0; i < n - 1; i++) {
        int x = in.nextInt() - 1, y = in.nextInt() - 1;
        graph[x].add(y);
        graph[y].add(x);
    }
    int start = -1;
    for (int i = 0; i < n; i++) {
        if (graph[i].size() > 2) {
            System.out.println("-1");
            System.exit(0);
        } else if (graph[i].size() == 1) {
            start = i;
        }
    }
    dfs(start);
    TreeSet<Long> ans = new TreeSet<>();
    ans.add(check(1, 2, 3));
    ans.add(check(1, 3, 2));
    ans.add(check(2, 1, 3));
    ans.add(check(2, 3, 1));
    ans.add(check(3, 1, 2));
    ans.add(check(3, 2, 1));
    if (ans.first() == check(1, 2, 3)) {
        lllkol(1, 2, 3);
    } else if (ans.first() == check(1, 3, 2)) {
        lllkol(1, 3, 2);
    } else if (ans.first() == check(2, 1, 3)) {
        lllkol(2, 1, 3);
    } else if (ans.first() == check(2, 3, 1)) {
        lllkol(2, 3, 1);
    } else if (ans.first() == check(3, 1, 2)) {
        lllkol(3, 1, 2);
    } else {
        lllkol(3, 2, 1);
    }
}