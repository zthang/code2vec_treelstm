void solve() {
    // Type solution here.
    int n = s.nextInt();
    long[] x = new long[n];
    long[] y = new long[n];
    for (int i = 0; i < n; i++) {
        x[i] = s.nextLong();
        y[i] = s.nextLong();
    }
    long[] c = new long[n];
    for (int i = 0; i < n; i++) {
        c[i] = s.nextLong();
    }
    long[] k = new long[n];
    for (int i = 0; i < n; i++) {
        k[i] = s.nextLong();
    }
    ArrayList<Pair>[] grph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        grph[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long len = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
            grph[i].add(new Pair(len, j));
            grph[j].add(new Pair(len, i));
        }
    }
    int src = 0;
    for (int i = 1; i < n; i++) {
        if (c[i] < c[src]) {
            src = i;
        }
    }
    // Stores elements in sorted order.
    TreeSet<Pair> set = new TreeSet<>();
    long[] dist = new long[n];
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) {
        dist[i] = Long.MAX_VALUE;
        parent[i] = -1;
    }
    boolean[] sptset = new boolean[n];
    dist[src] = c[src];
    set.add(new Pair(dist[src], src));
    while (!set.isEmpty()) {
        Pair p = set.pollFirst();
        int u = p.second;
        sptset[u] = true;
        for (int j = 0; j < grph[u].size(); j++) {
            Pair e = grph[u].get(j);
            int v = e.second;
            long w = Math.min(c[v], e.first * (k[u] + k[v]));
            if (!sptset[v] && dist[v] > w) {
                set.remove(new Pair(dist[v], v));
                dist[v] = w;
                set.add(new Pair(dist[v], v));
                if (dist[v] != c[v]) {
                    parent[v] = u;
                }
            }
        }
    }
    long val = 0;
    int num = 0;
    for (int i = 0; i < n; i++) {
        val += dist[i];
        if (parent[i] == -1) {
            num++;
        }
    }
    System.out.println(val);
    System.out.println(num);
    for (int i = 0; i < n; i++) {
        if (parent[i] == -1) {
            System.out.print((i + 1) + " ");
        }
    }
    System.out.println();
    System.out.println(n - num);
    for (int i = 0; i < n; i++) {
        if (parent[i] != -1) {
            System.out.print((parent[i] + 1) + " " + (i + 1) + " ");
        }
    }
}