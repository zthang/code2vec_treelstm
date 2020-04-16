public void solve(int testNumber, InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int[][] colorCost = new int[n + 1][3];
    for (int j = 0; j < 3; j++) {
        for (int i = 1; i <= n; i++) {
            colorCost[i][j] = sc.nextInt();
        }
    }
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
    }
    for (int i = 1; i < n; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    if (!linear(n, graph)) {
        out.println(-1);
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (graph.get(i).size() == 1) {
            String[] patterns = new String[] { "012", "021", "102", "120", "201", "210" };
            long answer = Long.MAX_VALUE;
            int[] color = new int[n + 1];
            for (String pattern : patterns) {
                int[] temporaryColor = new int[n + 1];
                long temporaryCost = dfs(i, -1, 0, temporaryColor, pattern, graph, colorCost);
                if (temporaryCost < answer) {
                    answer = temporaryCost;
                    color = temporaryColor;
                }
            }
            out.println(answer);
            for (int j = 1; j <= n; j++) {
                out.print(color[j] + " ");
            }
            break;
        }
    }
}