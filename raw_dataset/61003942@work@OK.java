long work() {
    int n = in.nextInt();
    int m = in.nextInt();
    w = new int[n];
    graph = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new ArrayList<>();
        w[i] = in.nextInt();
    }
    for (int i = 0; i < m; i++) {
        int n1 = in.nextInt() - 1;
        int n2 = in.nextInt() - 1;
        graph[n1].add(n2);
        graph[n2].add(n1);
    }
    int s = in.nextInt() - 1;
    dfs(s, -1, new boolean[n]);
    return sum + max;
}