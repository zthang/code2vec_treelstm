void work() {
    n = in.nextInt() * 2;
    max = 0;
    min = 0;
    graph = (ArrayList<int[]>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int s = in.nextInt() - 1;
        int e = in.nextInt() - 1;
        int t = in.nextInt();
        graph[s].add(new int[] { e, t });
        graph[e].add(new int[] { s, t });
    }
    boolean[] vis = new boolean[n];
    dfs(0, vis);
    out.println(min + " " + max);
}