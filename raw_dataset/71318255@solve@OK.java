int solve(int[] special) {
    int[] s = new int[n];
    int[] t = new int[n];
    Arrays.fill(s, -1);
    Arrays.fill(t, -1);
    s[0] = t[n - 1] = 0;
    Deque<Integer> q = new ArrayDeque<Integer>();
    q.add(0);
    while (!q.isEmpty()) {
        int u = q.pop();
        for (int v : adj[u]) {
            if (s[v] != -1)
                continue;
            s[v] = s[u] + 1;
            q.add(v);
        }
    }
    q.add(n - 1);
    while (!q.isEmpty()) {
        int u = q.pop();
        for (int v : adj[u]) {
            if (t[v] != -1)
                continue;
            t[v] = t[u] + 1;
            q.add(v);
        }
    }
    int k = special.length;
    SNode[] sn = new SNode[k];
    for (int i = 0; i < k; i++) sn[i] = new SNode(special[i], s[special[i]], t[special[i]]);
    Arrays.sort(sn);
    int[] sspecial = new int[special.length];
    int[] tspecial = new int[special.length];
    for (int i = 0; i < special.length; i++) {
        sspecial[i] = s[sn[i].node];
        tspecial[i] = t[sn[i].node];
    }
    int[] leftequal = new int[k];
    for (int i = 0; i < k; i++) leftequal[i] = i;
    for (int i = 1; i < k; i++) if (sn[i - 1].diff == sn[i].diff)
        leftequal[i] = leftequal[i - 1];
    RMQ trmq = new RMQ(tspecial);
    int shortest = s[n - 1];
    int longest = 0;
    for (int i = 0; i < k; i++) {
        int node = sn[i].node;
        int stonode = s[node];
        int worst = -1;
        int worstNode = -1;
        if (leftequal[i] < i) {
            int dist = trmq.query(leftequal[i], i - 1);
            int index = trmq.queryIndex(leftequal[i], i - 1);
            if (dist > worst) {
                dist = worst;
                worstNode = sn[index].node;
            }
        }
        if (i + 1 < k) {
            int dist = trmq.query(i + 1, k - 1);
            int index = trmq.queryIndex(i + 1, k - 1);
            if (dist > worst) {
                dist = worst;
                worstNode = sn[index].node;
            }
        }
        if (worstNode == -1)
            continue;
        int nodetot = t[worstNode];
        longest = max(longest, stonode + nodetot + 1);
    }
    return min(shortest, longest);
}