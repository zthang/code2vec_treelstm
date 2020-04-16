static void solve() throws Exception {
    int n = scanInt(), m = scanInt();
    IntList[] edges = new IntList[n];
    for (int i = 0; i < n; i++) {
        edges[i] = new IntList();
    }
    for (int i = 0; i < m; i++) {
        int a = scanInt() - 1, b = scanInt() - 1;
        edges[a].push(b);
        edges[a].push(i + 1);
        edges[b].push(a);
        edges[b].push(i + 1);
    }
    Token[] toks = new Token[n];
    toks[0] = new Token(0, 0, -1, 0, 0);
    PriorityQueue<Token> q = new PriorityQueue<>();
    q.add(toks[0]);
    boolean[] processed = new boolean[n];
    do {
        Token tok = q.remove();
        int cur = tok.id;
        if (processed[cur]) {
            continue;
        }
        processed[cur] = true;
        IntList cEdges = edges[cur];
        for (int i = 0; i < cEdges.size; i += 2) {
            int next = cEdges.data[i], nextE = cEdges.data[i + 1];
            Token tNext = tok.append(nextE, next);
            if (toks[next] == null || tNext.compareTo(toks[next]) < 0) {
                toks[next] = tNext;
                q.add(tNext);
            }
        }
    } while (!q.isEmpty());
    for (int i = 1; i < n; i++) {
        out.println(toks[i].val);
    }
}