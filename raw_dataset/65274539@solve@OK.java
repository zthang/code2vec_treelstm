void solve(int testNumber, FastScanner s, PrintWriter out) {
    N = s.nextInt();
    M = s.nextInt();
    K = s.nextInt();
    Q = s.nextInt();
    Arrays.setAll(adj = new ArrayList[N], x -> new ArrayList<>());
    for (int m = 0, u, v, w; m < M; m++) {
        u = s.nextInt() - 1;
        v = s.nextInt() - 1;
        w = s.nextInt();
        adj[u].add(new int[] { v, w });
        adj[v].add(new int[] { u, w });
    }
    unions = new int[N - 1][2];
    limits = new long[N - 1];
    IDX = 0;
    PriorityQueue<State> q = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
    Arrays.fill(dist = new long[N], oo);
    for (int i = 0; i < K; i++) {
        q.add(new State(i, 0));
        dist[i] = 0;
    }
    State cur;
    long cdist, dto;
    int vtx, to;
    // multi source dijkstra - get closest station to all vertices
    while (!q.isEmpty()) {
        cur = q.poll();
        cdist = cur.dist;
        vtx = cur.vtx;
        // outdated
        if (dist[vtx] < cdist)
            continue;
        for (int[] e : adj[vtx]) {
            to = e[0];
            dto = cdist + e[1];
            if (dist[to] > dto) {
                dist[to] = dto;
                q.add(new State(to, dto));
            }
        }
    }
    PriorityQueue<Edge> eq = new PriorityQueue<>((a, b) -> Long.compare(a.thr, b.thr));
    for (int i = 0; i < N; i++) for (int[] e : adj[i]) if (e[0] > i)
        eq.add(new Edge(i, e[0], e[1] + dist[i] + dist[e[0]]));
    DSU = new DisjointSet(N);
    Edge ce;
    while (IDX < N - 1) {
        ce = eq.poll();
        if (!DSU.union(ce.a, ce.b))
            continue;
        unions[IDX][0] = ce.a;
        unions[IDX][1] = ce.b;
        limits[IDX++] = ce.thr;
    }
    int[] qAns = new int[Q];
    qq = new ArrayDeque[2][N];
    Arrays.fill(qAns, N - 1);
    Arrays.setAll(qq[0], x -> new ArrayDeque<>());
    Arrays.setAll(qq[1], x -> new ArrayDeque<>());
    for (int i = 0, m = N - 1 >> 1; i < Q; i++) qq[0][m].add(new Query(s.nextInt() - 1, s.nextInt() - 1, 0, N - 1, i));
    int done = 0, w = 0;
    while (done < Q) {
        // pass through disjoint set, update queries
        Arrays.fill(DSU.s, -1);
        for (int i = 0; i < N - 1; i++) {
            DSU.union(unions[i][0], unions[i][1]);
            // process queries at this time step
            while (!qq[w][i].isEmpty()) {
                Query curq = qq[w][i].poll();
                if (DSU.find(curq.a) == DSU.find(curq.b)) {
                    // they've been joined by now
                    qAns[curq.qi] = i;
                    curq.hi = curq.m - 1;
                    curq.recalc();
                } else {
                    // they've not been joined
                    curq.lo = curq.m + 1;
                    curq.recalc();
                }
                if (curq.lo > curq.hi)
                    done++;
                else
                    qq[w ^ 1][curq.m].add(curq);
            }
        }
        // flip the queue we use
        w ^= 1;
    }
    for (int x : qAns) out.println(limits[x]);
}