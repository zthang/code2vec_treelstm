public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt(), k = in.nextInt();
    List<Integer>[] graph = Utils.listArray(n);
    for (int i = 0; i < k; i++) {
        int from = in.nextInt() - 1, to = in.nextInt() - 1;
        graph[from].add(to);
        graph[to].add(from);
    }
    boolean[] used = new boolean[n];
    int[] q = new int[n];
    int comps = 0;
    for (int i = 0; i < n; i++) {
        if (!used[i]) {
            used[i] = true;
            int head = 0, tail = 0;
            q[tail++] = i;
            comps++;
            while (head < tail) {
                int cur = q[head++];
                for (int v : graph[cur]) {
                    if (!used[v]) {
                        used[v] = true;
                        q[tail++] = v;
                    }
                }
            }
        }
    }
    out.println(k - (n - comps));
}