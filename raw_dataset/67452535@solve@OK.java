public void solve(int testNumber, FastReader scan, PrintWriter out) {
    n = scan.nextInt();
    a = new int[n];
    dist = new int[n][2];
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
        dist[i][0] = dist[i][1] = -1;
    }
    for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
        if (i + a[i] < n)
            adj[i + a[i]].add(i);
        if (i - a[i] >= 0)
            adj[i - a[i]].add(i);
        dist[i][a[i] % 2] = 0;
        index.addLast(i);
        parity.addLast(a[i] %= 2);
    }
    while (!index.isEmpty()) {
        int curr = index.pollFirst(), p = parity.pollFirst();
        for (int i : adj[curr]) {
            if (dist[i][p] == -1) {
                dist[i][p] = dist[curr][p] + 1;
                index.addLast(i);
                parity.addLast(p);
            }
        }
    }
    for (int i = 0; i < n; i++) {
        out.print(dist[i][a[i] ^ 1]);
        out.print(" ");
    }
}