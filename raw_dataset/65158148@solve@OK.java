public void solve(InputReader in, PrintWriter out, boolean debug) {
    int n = in.nextInt();
    int m = in.nextInt();
    Map<Integer, Set<Integer>> w = new HashMap<>();
    int[] parent = new int[n + 1];
    int[] sz = new int[n + 1];
    int[] edges = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
        sz[i] = 1;
        edges[i] = n;
        w.put(i, new HashSet<>());
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        w.get(a).add(b);
        w.get(b).add(a);
        edges[a]--;
        edges[b]--;
    }
    int first = Collections.min(w.keySet(), Comparator.comparing(k -> w.get(k).size()));
    int ds = n;
    Set<Integer> remaining = new HashSet<>();
    Set<Integer> toRemove = new HashSet<>();
    for (int i = 1; i <= n; i++) {
        remaining.add(i);
    }
    remaining.remove(first);
    for (int j : remaining) {
        if (!w.get(first).contains(j)) {
            ds = union(parent, sz, ds, first, j);
            toRemove.add(j);
        }
    }
    remaining.removeAll(toRemove);
    for (int i : remaining) {
        for (int j = 1; j <= n; j++) {
            if (!w.get(i).contains(j)) {
                ds = union(parent, sz, ds, i, j);
            }
        }
    }
    if (debug) {
        out.println(Arrays.toString(parent));
    }
    out.println(ds - 1);
}