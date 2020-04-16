public void solve(int testNumber, LightScanner in, LightWriter out) {
    // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
    int n = in.ints(), m = in.ints();
    B01MST.Node[] nodes = new B01MST.Node[n];
    for (int i = 0; i < n; i++) {
        nodes[i] = new B01MST.Node(i);
    }
    for (int i = 0; i < m; i++) {
        int x = in.ints() - 1, y = in.ints() - 1;
        nodes[x].adj.add(nodes[y]);
        nodes[y].adj.add(nodes[x]);
    }
    int ans = 0;
    boolean[] connected = new boolean[n];
    Queue<B01MST.Node> zerocost = new ArrayDeque<>();
    zerocost.offer(nodes[0]);
    TreeSet<B01MST.Node> cost = new TreeSet<>();
    for (int i = 0; i < n; i++) cost.add(nodes[i]);
    for (int count = 0; count < n; ) {
        while (!zerocost.isEmpty()) {
            B01MST.Node node = zerocost.poll();
            if (connected[node.index])
                continue;
            connected[node.index] = true;
            for (B01MST.Node adj : node.adj) {
                if (!connected[adj.index]) {
                    cost.remove(adj);
                    adj.paths++;
                    cost.add(adj);
                }
            }
            count++;
        }
        while (!cost.isEmpty() && cost.first().paths < count) {
            B01MST.Node node = cost.pollFirst();
            if (!connected[node.index]) {
                zerocost.offer(node);
            }
        }
        while (!cost.isEmpty() && zerocost.isEmpty()) {
            B01MST.Node node = cost.pollFirst();
            if (!connected[node.index]) {
                zerocost.offer(node);
                ans++;
            }
        }
    }
    out.ans(ans).ln();
}