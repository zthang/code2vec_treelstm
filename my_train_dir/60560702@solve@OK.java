public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    graph = Utils.listArray(n + 40 * m);
    vertices = n;
    for (int i = 1; i <= m; i++) {
        int from = in.nextInt() - 1, to = in.nextInt() - 1;
        String s = Integer.toString(i);
        addEdge(from, to, s);
        addEdge(to, from, s);
    }
    for (int i = 0; i < n; i++) {
        if (graph[i].size() > 1) {
            Collections.sort(graph[i]);
        }
    }
    int mod = 1000000007;
    int[] dist = new int[graph.length];
    Arrays.fill(dist, -1);
    dist[0] = 0;
    int[] q = new int[graph.length];
    int head = 0, tail = 0;
    q[tail++] = 0;
    int[] val = new int[graph.length];
    Arrays.fill(val, -1);
    val[0] = 0;
    int[] hash = new int[graph.length];
    Arrays.fill(hash, -1);
    hash[0] = 0;
    int prime = BigInteger.probablePrime(30, new SecureRandom()).intValue();
    int[] lastChar = new int[graph.length];
    Arrays.fill(lastChar, 10);
    int[] count = new int[10];
    while (head < tail) {
        int endSegment = head;
        int start = q[head];
        while (endSegment < tail && hash[q[endSegment]] == hash[start]) {
            endSegment++;
        }
        Arrays.fill(count, 0);
        for (int pos = head; pos < endSegment; pos++) {
            int cur = q[pos];
            for (int t = 0; t < graph[cur].size(); t++) {
                int edge = graph[cur].get(t);
                int c = edge >> 24;
                int v = edge & ((1 << 24) - 1);
                if (dist[v] == -1) {
                    if (lastChar[v] < 10) {
                        count[lastChar[v]]--;
                    }
                    lastChar[v] = Math.min(lastChar[v], c);
                    count[lastChar[v]]++;
                }
            }
        }
        for (int pos = 1; pos < 10; pos++) {
            count[pos] += count[pos - 1];
        }
        int added = count[9];
        for (int pos = head; pos < endSegment; pos++) {
            int cur = q[pos];
            for (int t = 0; t < graph[cur].size(); t++) {
                int edge = graph[cur].get(t);
                int v = edge & ((1 << 24) - 1);
                if (dist[v] == -1) {
                    dist[v] = dist[start] + 1;
                    val[v] = (int) ((10L * val[start] + lastChar[v]) % mod);
                    hash[v] = (int) ((10L * hash[start] + lastChar[v]) % prime);
                    --count[lastChar[v]];
                    q[tail + count[lastChar[v]]] = v;
                }
            }
        }
        head = endSegment;
        tail += added;
    }
    for (int i = 1; i < n; i++) {
        out.println(val[i]);
    }
}