public void solve(InputReader in, PrintWriter out) throws IOException {
    int n = in.nextInt();
    int[] arr = in.readIntArray(n);
    // int arr[] = {10,3,10,3,5,4,10,9,9,8,7,10,3,10,8,9,7,7,8,10,7,8,3,10,4,5,10,10,3,9,10,6,9,9,7,6,10,4,3,8,7,7,3,9,9,8,7,5,4,5,3,8,4,4,5,3,9,6,9,9,6,9,3,4,5,6,5,10,5,4,6,10,3,4,4,8,8,3,9,7,8,10,6,5,8,3,4,6,8,9,8,9,4,3,10,8,8,10,7,3};
    int m = n + 1;
    ArrayList<edge>[] g = new ArrayList[m];
    for (int i = 0; i < m; i++) g[i] = new ArrayList<edge>();
    int max = 999999999;
    for (int i = 0; i < n; i++) {
        g[n].add(new edge(n, i, max));
        if (i - arr[i] >= 0) {
            if (arr[i - arr[i]] % 2 != arr[i] % 2) {
                g[n].add(new edge(n, i, 1));
                continue;
            } else {
                g[i - arr[i]].add(new edge(i - arr[i], i, 1));
            }
        }
        if (i + arr[i] < n) {
            if (arr[i + arr[i]] % 2 != arr[i] % 2) {
                g[n].add(new edge(n, i, 1));
            } else {
                g[i + arr[i]].add(new edge(i + arr[i], i, 1));
            }
        }
    }
    int[] dist = new int[m];
    Arrays.fill(dist, max + 1);
    PriorityQueue<pair> pq = new PriorityQueue<pair>();
    boolean[] vis = new boolean[m];
    pq.add(new pair(n, 0));
    dist[n] = 0;
    for (int i = 0; i < n; i++) {
        while (!pq.isEmpty() && vis[pq.peek().idx]) pq.poll();
        pair min = pq.poll();
        vis[min.idx] = true;
        for (edge e : g[min.idx]) {
            if (!vis[e.t] && dist[e.t] > dist[min.idx] + e.len) {
                dist[e.t] = dist[min.idx] + e.len;
                pq.add(new pair(e.t, dist[e.t]));
            }
        }
    }
    for (int i = 0; i < n; i++) {
        out.print(dist[i] >= max ? -1 : dist[i]);
        out.print(" ");
    }
    out.println();
    out.close();
}