public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    // 0 = unassigned; 1,2,3 = assigned
    int[] component = new int[n];
    Set<Integer>[] adj = new Set[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new HashSet<>();
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    for (int currentComponent = 1; currentComponent <= 3; currentComponent++) {
        for (int i = 0; i < n; i++) {
            if (component[i] == 0) {
                component[i] = currentComponent;
                for (int j = 0; j < n; j++) {
                    if (j == i)
                        continue;
                    if (!adj[i].contains(j)) {
                        if (component[j] == 0) {
                            component[j] = currentComponent;
                        } else {
                            out.println(-1);
                            return;
                        }
                    }
                }
                break;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j : adj[i]) {
            if (component[i] == component[j]) {
                out.println(-1);
                return;
            }
        }
    }
    int[] count = new int[4];
    for (int x : component) {
        count[x]++;
    }
    if (count[1] == 0 || count[2] == 0 || count[3] == 0) {
        out.println(-1);
        return;
    }
    if (count[0] != 0) {
        out.println(-1);
        return;
    }
    long totalEdges = count[1] * count[2] + count[2] * count[3] + count[3] * count[1];
    if (totalEdges != m) {
        out.println(-1);
        return;
    }
    out.println(Util.join(component));
}