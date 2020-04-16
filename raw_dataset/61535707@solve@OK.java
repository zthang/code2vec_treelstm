public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int m = in.nextInt();
    graph = new Graph(n);
    tags = new int[n];
    for (int i = 0; i < 3; i++) {
        lists.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        graph.addEdge(u, v);
        graph.addEdge(v, u);
        edges.add(Pair.ofUnique(u, v));
    }
    disjointSet = new DisjointSet(n);
    int current = 0;
    int[] count = new int[3];
    for (int i = 0; i < n; i++) {
        if (disjointSet.find(i) == i) {
            if (current == 3) {
                out.println(-1);
                return;
            }
            count[current] = process(i, current);
            current++;
        }
    }
    if (current != 3 || (long) count[0] * count[1] + (long) count[1] * count[2] + (long) count[0] * count[2] != m) {
        out.println(-1);
        return;
    }
    for (int i = 0; i < 3; i++) {
        for (int j = i + 1; j < 3; j++) {
            List<Integer> first = lists.get(i);
            List<Integer> second = lists.get(j);
            for (int u : first) {
                for (int v : second) {
                    if (!edges.contains(Pair.ofUnique(u, v))) {
                        out.println(-1);
                        return;
                    }
                }
            }
        }
    }
    out.printInts(tags);
}