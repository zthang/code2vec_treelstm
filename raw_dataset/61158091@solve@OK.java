public void solve(int testNumber, InputReader in, OutputWriter out) {
    permutations = new HashSet<>();
    int N = in.nextInt(), M = in.nextInt();
    boolean[][] hasEdge = new boolean[N][N];
    int[][] edges = new int[M][2];
    int[] degrees = new int[N];
    for (int i = 0; i < M; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        hasEdge[u][v] = true;
        hasEdge[v][u] = true;
        edges[i][0] = u;
        edges[i][1] = v;
        degrees[u]++;
        degrees[v]++;
    }
    if (N <= 6) {
        out.printLine(M);
        return;
    }
    boolean[] visited = new boolean[N];
    dfs(0, visited, hasEdge);
    boolean hasMoreCom = false;
    for (int i = 0; i < N; i++) {
        if (!visited[i]) {
            hasMoreCom = true;
            break;
        }
    }
    if (hasMoreCom) {
        out.printLine(M);
        return;
    }
    int max = 0;
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            int c = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int k = 0; k < M; k++) {
                if (edges[k][0] != i && edges[k][1] != i && edges[k][0] != j && edges[k][1] != j) {
                    c++;
                } else {
                    set.add(edges[k][0]);
                    set.add(edges[k][1]);
                // if ((edges[k][0] == i && edges[k][1] != j) || (edges[k][0] == j && edges[k][1] != i)) {
                // set.add(edges[k][1]);
                // } else if ((edges[k][1] == i && edges[k][0] != j) || (edges[k][1] == j && edges[k][0] != i)) {
                // set.add(edges[k][0]);
                // }
                }
            }
            set.remove(i);
            set.remove(j);
            if (hasEdge[i][j]) {
                c++;
            }
            max = Math.max(max, c + set.size());
        }
    }
    out.printLine(max);
}