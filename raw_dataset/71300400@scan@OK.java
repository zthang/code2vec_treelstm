static void scan() throws IOException {
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    good = new boolean[n];
    dist1 = new int[n];
    dist2 = new int[n];
    gr = new ArrayList[n];
    for (int i = 0; i < k; i++) good[sc.nextInt() - 1] = true;
    for (int i = 0; i < n; i++) gr[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int v1 = sc.nextInt() - 1;
        int v2 = sc.nextInt() - 1;
        gr[v1].add(v2);
        gr[v2].add(v1);
    }
    bfs(0, dist1);
    bfs(n - 1, dist2);
}