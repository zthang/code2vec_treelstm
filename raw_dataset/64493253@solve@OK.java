static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int n = ni(), m = ni();
    HashSet<Integer>[] adj = new HashSet[n + 1];
    for (int i = 1; i <= n; ++i) {
        adj[i] = new HashSet<>();
    }
    for (int i = 0; i < m; ++i) {
        int u = ni(), v = ni();
        adj[u].add(v);
        adj[v].add(u);
    }
    HashSet<Integer> remaining = new HashSet<>();
    for (int i = 1; i <= n; ++i) {
        remaining.add(i);
    }
    LinkedList<Integer> queue = new LinkedList<>();
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        if (remaining.contains(i)) {
            ans++;
            queue.add(i);
            remaining.remove(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (remaining.size() < adj[curr].size()) {
                    ArrayList<Integer> removed = new ArrayList<>();
                    for (int e : remaining) {
                        if (!adj[curr].contains(e)) {
                            removed.add(e);
                        }
                    }
                    for (int e : removed) {
                        remaining.remove(e);
                        queue.add(e);
                    }
                } else {
                    HashSet<Integer> new_remaining = new HashSet<>();
                    ArrayList<Integer> removed = new ArrayList<>();
                    for (int e : remaining) {
                        if (!adj[curr].contains(e)) {
                            removed.add(e);
                            queue.add(e);
                        } else {
                            new_remaining.add(e);
                        }
                    }
                    remaining = new_remaining;
                    for (int e : removed) {
                        remaining.remove(e);
                        queue.add(e);
                    }
                }
            }
            pl();
        }
    }
    pl((ans - 1));
    pw.flush();
    pw.close();
}