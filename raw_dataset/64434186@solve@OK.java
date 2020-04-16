public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    TreeSet<Integer>[] adj = new TreeSet[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new TreeSet<>();
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) set.add(i);
    int ans = 0;
    for (int i = 0; i < n; i++) if (set.contains(i) == true) {
        ans++;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(i);
        set.remove(i);
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            ArrayList<Integer> goodNodes = new ArrayList<>();
            for (int node : set) if (adj[cur].contains(node) == false)
                goodNodes.add(node);
            for (int goodNode : goodNodes) {
                Q.add(goodNode);
                set.remove(goodNode);
            }
        }
    }
    out.println(ans - 1);
}