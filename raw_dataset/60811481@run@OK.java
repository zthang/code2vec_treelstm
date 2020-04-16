void run() {
    int n = nextInt();
    int m = nextInt();
    int[] w = nextArray(n);
    List<Integer>[] g = new List[n];
    Set<Integer>[] set = new Set[n];
    for (int i = 0; i < n; i++) {
        g[i] = new ArrayList<Integer>();
        set[i] = new HashSet<Integer>();
    }
    for (int i = 0; i < m; i++) {
        Integer u = nextInt() - 1, v = nextInt() - 1;
        g[u].add(v);
        g[v].add(u);
        set[u].add(v);
        set[v].add(u);
    }
    Queue<Integer> queue = new ArrayDeque<Integer>();
    for (int i = 0; i < n; i++) {
        if (set[i].size() == 1) {
            queue.add(i);
        }
    }
    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (Integer v : g[u]) {
            set[v].remove(u);
            if (set[v].size() == 1) {
                queue.add(v);
            }
        }
        set[u].clear();
    }
    int s = nextInt() - 1;
    long loopSum = 0;
    long treeSum = 0;
    for (int u = 0; u < n; u++) {
        if (set[u].isEmpty()) {
            boolean root = false;
            for (int v : g[u]) {
                root |= (set[v].isEmpty() == false);
            }
            if (root) {
                Set<Integer> tree = new HashSet<Integer>();
                long cur = dfs1(-1, u, w, set, tree, g);
                if (tree.contains(s)) {
                    Set<Integer> path = new HashSet<Integer>();
                    dfs3(-1, s, w, set, g, path);
                    for (int v : path) {
                        cur -= w[v];
                    }
                }
                treeSum = max(treeSum, cur);
            }
        } else {
            loopSum += w[u];
        }
    }
    if (set[s].isEmpty()) {
        println(dfs2(-1, s, w, set, g, loopSum + treeSum));
    } else {
        println(loopSum + treeSum);
    }
}