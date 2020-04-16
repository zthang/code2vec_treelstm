void startProgram() {
    while (k.hasNext()) {
        n = k.nextInt();
        m = k.nextInt();
        graph = new HashSet[n + 1];
        nodes = new TreeSet<Integer>();
        queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
            nodes.add(i);
        }
        while (m-- > 0) {
            int u = k.nextInt();
            int v = k.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        startAlgo();
    }
    z.flush();
    System.exit(0);
}