public void solve() {
    int n = io.readInt();
    int m = io.readInt();
    checker = new ConnectionChecker(n);
    Query[][] queries = new Query[2][m];
    Map<Long, Query> edgeMap = new HashMap<>(m);
    exist = new HashSet<>(m);
    for (int i = 0; i < m; i++) {
        int t = io.readInt();
        int x = io.readInt();
        int y = io.readInt();
        for (int j = 0; j < 2; j++) {
            queries[j][i] = new Query();
            queries[j][i].t = t;
            queries[j][i].x = (x + j - 1) % n;
            queries[j][i].y = (y + j - 1) % n;
            queries[j][i].edgeId = idOfEdge(queries[j][i].x, queries[j][i].y);
            queries[j][i].time = i;
        }
        queries[0][i].opposite = queries[1][i];
        queries[1][i].opposite = queries[0][i];
    }
    for (int i = m - 1; i >= 0; i--) {
        if (queries[0][i].t == 2) {
            continue;
        }
        for (int j = 0; j < 2; j++) {
            queries[j][i].next = edgeMap.get(queries[j][i].edgeId);
        }
        for (int j = 0; j < 2; j++) {
            edgeMap.put(queries[j][i].edgeId, queries[j][i]);
        }
    }
    int last = 0;
    for (int i = 0; i < m; i++) {
        Query q = queries[last][i];
        checker.elapse(q.time);
        if (q.t == 2) {
            last = checker.check(q.x, q.y) ? 1 : 0;
            io.cache.append(last);
            continue;
        }
        if (q.revokeOpp && !equal(q, q.opposite)) {
            addEdge(q.opposite);
        }
        if (exist.contains(q.edgeId)) {
            exist.remove(q.edgeId);
            continue;
        }
        addEdge(q);
    }
}