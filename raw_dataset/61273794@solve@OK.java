private void solve(InputReader inp, PrintWriter out) {
    int n = inp.nextInt(), m = inp.nextInt();
    ArrayList<Integer>[] graph = new ArrayList[n];
    int[] set = new int[m];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int u = inp.nextInt() - 1, v = inp.nextInt() - 1;
        graph[u].add(v);
        set[i] = (u < v) ? 1 : 2;
    }
    boolean cycle = false;
    for (int i = 0; i < n; i++) if (cycle(graph, i))
        cycle = true;
    out.println(cycle ? 2 : 1);
    for (int i = 0; i < m; i++) out.print((cycle ? set[i] : 1) + " ");
}