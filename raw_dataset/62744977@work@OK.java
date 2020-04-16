int work() {
    int n = in.nextInt();
    graph = (ArrayList<Integer>[]) new ArrayList[n];
    rec = (ArrayList<int[]>[]) new ArrayList[n];
    ret = 0;
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) rec[i] = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int n1 = in.nextInt() - 1;
        int n2 = in.nextInt() - 1;
        graph[n1].add(n2);
        graph[n2].add(n1);
    }
    dfs1(0, new boolean[n]);
    dfs2(0, 0);
    return ret;
}