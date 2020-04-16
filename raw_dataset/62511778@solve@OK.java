public void solve(int testNumber, InputReader in, OutputWriter out) {
    N = in.nextInt();
    long[][] costs = new long[N][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < N; j++) {
            costs[j][i] = in.nextInt();
        }
    }
    graph = new List[N];
    for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int i = 1; i < N; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        graph[u].add(v);
        graph[v].add(u);
    }
    int startVertex = -1;
    for (int i = 0; i < N; i++) {
        if (graph[i].size() >= 3) {
            out.printLine(-1);
            return;
        }
        if (graph[i].size() == 1) {
            startVertex = i;
        }
    }
    long cost = (long) 1e18;
    StringBuilder str = new StringBuilder();
    int[] optimalColor = new int[N];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j)
                continue;
            int[] color = new int[N];
            int lastVertex = -1;
            int currentVertex = startVertex;
            currentVertex = getNextVertex(currentVertex, lastVertex);
            long currentCost = costs[startVertex][i] + costs[currentVertex][j];
            color[startVertex] = i + 1;
            color[currentVertex] = j + 1;
            lastVertex = startVertex;
            int last = j;
            int prevToLast = i;
            for (int k = 2; k < N; k++) {
                int index = 3 - last - prevToLast;
                int nextVertex = getNextVertex(currentVertex, lastVertex);
                currentCost += costs[nextVertex][index];
                color[nextVertex] = index + 1;
                prevToLast = last;
                last = index;
                lastVertex = currentVertex;
                currentVertex = nextVertex;
            }
            if (currentCost < cost) {
                cost = currentCost;
                optimalColor = color;
            }
        }
    }
    out.printLine(cost);
    for (int i = 0; i < N; i++) {
        out.print(optimalColor[i] + " ");
    }
}