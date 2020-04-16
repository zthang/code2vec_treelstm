public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    long[] scores = in.readLongArray(n);
    HashSet<Integer>[] edges = new HashSet[n];
    for (int i = 0; i < n; i++) edges[i] = new HashSet<>();
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1, b = in.nextInt() - 1;
        edges[a].add(b);
        edges[b].add(a);
    }
    int s = in.nextInt() - 1;
    long[] maxtail = new long[n];
    HashSet<Integer> active = new HashSet<>();
    for (int i = 0; i < n; i++) active.add(i);
    int[] queue = new int[n];
    int front = 0, back = 0;
    for (int i = 0; i < n; i++) {
        if (edges[i].size() == 1 && i != s) {
            queue[back++] = i;
        }
    }
    while (front < back) {
        int cur = queue[front++];
        active.remove(cur);
        int nxt = edges[cur].iterator().next();
        maxtail[nxt] = Math.max(maxtail[nxt], maxtail[cur] + scores[cur]);
        edges[nxt].remove(cur);
        if (edges[nxt].size() == 1 && nxt != s) {
            queue[back++] = nxt;
        }
    }
    long ans = 0;
    long add = 0;
    for (int i : active) {
        ans += scores[i];
        add = Math.max(add, maxtail[i]);
    }
    out.println(ans + add);
}