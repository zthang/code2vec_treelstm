void work() {
    int n = in.nextInt();
    int m = in.nextInt();
    // index
    graph = (ArrayList<int[]>[]) new ArrayList[n + 1];
    visited = new int[n + 1];
    color = new int[m + 1];
    Arrays.fill(color, 1);
    for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int i = 1; i <= m; i++) {
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        graph[n1].add(new int[] { n2, i });
    }
    for (int i = 1; i <= n; i++) {
        if (visited[i] == 0) {
            dfs(i);
        }
    }
    out.println(ret);
    for (int i = 1; i <= m; i++) {
        out.print(color[i] + " ");
    }
}