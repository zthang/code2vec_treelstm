void startProgram() {
    while (k.hasNext()) {
        n = k.nextInt();
        color = new long[3][n + 1];
        graph = new ArrayList[n + 1];
        result = new int[n + 1];
        colorMap = new int[3];
        minColorMap = new int[3];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int node = 1; node <= n; node++) {
                color[i][node] = k.nextInt();
            }
        }
        boolean isPossible = true;
        for (int i = 0; i < n - 1; i++) {
            int u = k.nextInt();
            int v = k.nextInt();
            graph[u].add(v);
            graph[v].add(u);
            if (graph[u].size() > 2 || graph[v].size() > 2) {
                isPossible = false;
            }
        }
        if (isPossible) {
            startAlgo(getRoot());
        } else {
            z.println(-1);
        }
    }
    z.flush();
    System.exit(0);
}