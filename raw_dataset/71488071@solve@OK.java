private int solve(List<Integer>[] adj, int[] k) {
    int[] x = new int[adj.length];
    int[] y = new int[adj.length];
    Queue<Integer> q = new LinkedList<>();
    Arrays.fill(x, -1);
    x[0] = 0;
    q.add(0);
    while (!q.isEmpty()) {
        Integer u = q.remove();
        for (int v : adj[u]) {
            if (x[v] == -1) {
                x[v] = x[u] + 1;
                q.add(v);
            }
        }
    }
    Arrays.fill(y, -1);
    y[y.length - 1] = 0;
    q.add(y.length - 1);
    while (!q.isEmpty()) {
        Integer u = q.remove();
        for (int v : adj[u]) {
            if (y[v] == -1) {
                y[v] = y[u] + 1;
                q.add(v);
            }
        }
    }
    int[] z = IntStream.range(0, k.length).map(i -> x[k[i]] - y[k[i]]).toArray();
    Integer[] sz = IntStream.range(0, z.length).boxed().toArray(Integer[]::new);
    Arrays.sort(sz, (i, j) -> Integer.compare(z[i], z[j]));
    int[] maxy = new int[k.length];
    maxy[k.length - 1] = y[k[sz[k.length - 1]]];
    for (int i = k.length - 2; i >= 0; i--) {
        maxy[i] = Math.max(maxy[i + 1], y[k[sz[i]]]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < z.length - 1; i++) {
        int sum = x[k[sz[i]]] + maxy[i + 1];
        max = Math.max(max, sum);
    }
    return Math.min(y[0], max + 1);
}