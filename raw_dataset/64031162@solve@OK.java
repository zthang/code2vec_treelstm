public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        y[i] = in.ni();
    }
    long[] power = new long[n];
    long[] k = new long[n];
    for (int i = 0; i < n; i++) power[i] = in.nl();
    for (int i = 0; i < n; i++) k[i] = in.nl();
    PriorityQueue<Action> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
        queue.add(new Action(1, i, power[i]));
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long dist = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
            long cost = dist * (k[i] + k[j]);
            queue.add(new Action(2, i, j, cost));
        }
    }
    long totalCost = 0;
    List<Integer> powerHouses = new ArrayList<>();
    List<int[]> connections = new ArrayList<>();
    DisjointSet dsu = new DisjointSet(n);
    int cnt = 0;
    boolean[] hasLight = new boolean[n];
    while (queue.size() > 0) {
        if (cnt == n)
            break;
        Action action = queue.poll();
        if (action.type == 1) {
            int city = action.u, root = dsu.root(city);
            if (!hasLight[root]) {
                hasLight[root] = true;
                powerHouses.add(city + 1);
                totalCost += action.cost;
                cnt += dsu.size[root];
            }
        } else {
            int a = dsu.root(action.u), b = dsu.root(action.v);
            int size_a = dsu.size[a], size_b = dsu.size[b];
            if (hasLight[a] && hasLight[b])
                continue;
            if (dsu.join(a, b)) {
                totalCost += action.cost;
                connections.add(new int[] { action.u + 1, action.v + 1 });
                if (hasLight[a]) {
                    hasLight[b] = true;
                    cnt += size_b;
                } else if (hasLight[b]) {
                    hasLight[a] = true;
                    cnt += size_a;
                }
            }
        }
    }
    out.println(totalCost);
    out.println(powerHouses.size());
    for (int powerHouse : powerHouses) {
        out.print(powerHouse);
        out.print(' ');
    }
    out.println();
    out.println(connections.size());
    for (int[] pair : connections) {
        out.println(pair[0] + " " + pair[1]);
    }
}