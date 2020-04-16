static TreeSet<Integer> MIS() {
    TreeSet<Integer> is = new TreeSet<>();
    TreeSet<Pair> set = new TreeSet<>();
    int[] deg = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
        set.add(new Pair(adj[i].size(), i));
        deg[i] = adj[i].size();
    }
    while (!set.isEmpty()) {
        Pair v = set.pollFirst();
        for (int e : adj[v.y]) {
            if (set.contains(new Pair(deg[e], e))) {
                for (int f : adj[e]) {
                    if (set.contains(new Pair(deg[f], f))) {
                        set.remove(new Pair(deg[f], f));
                        set.add(new Pair(--deg[f], f));
                    }
                }
                set.remove(new Pair(deg[e], e));
            }
        }
        is.add(v.y);
    }
    return is;
}