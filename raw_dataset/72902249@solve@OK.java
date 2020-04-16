public void solve() {
    int n = in.ni(), m = in.ni();
    dist = new int[n + 1];
    for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
        dist[i] = -1;
    }
    for (int i = 0; i < m; i++) {
        int v = in.ni(), u = in.ni();
        graph.get(u).add(v);
    }
    k = in.ni();
    route = new int[k];
    for (int i = 0; i < k; i++) {
        route[i] = in.ni();
    }
    bfs();
    int min = 0, max = 0, prevOptimal = dist[route[0]];
    for (int idx = 1; idx < route.length - 1; idx++) {
        int curOptimal = dist[route[idx]];
        if (curOptimal != prevOptimal - 1) {
            min++;
            max++;
        } else if (multiOptimal[route[idx - 1]]) {
            max++;
        }
        prevOptimal = dist[route[idx]];
    }
    out.println(min + " " + max);
}