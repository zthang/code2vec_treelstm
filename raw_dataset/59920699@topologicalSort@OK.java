private static int[] topologicalSort(ArrayList<Integer>[] graph) {
    int n = graph.length;
    int[] in_degree = new int[n];
    for (int i = 0; i < n; i++) {
        for (int to : graph[i]) in_degree[to]++;
    }
    int[] res = new int[n];
    int j = 0;
    for (int i = 0; i < n; i++) {
        if (in_degree[i] == 0)
            res[j++] = i;
    }
    for (int i = 0; i < j; i++) {
        for (int to : graph[res[i]]) {
            if (--in_degree[to] == 0)
                res[j++] = to;
        }
    }
    for (int i = 0; i < n; i++) {
        if (in_degree[i] > 0) {
            // graph contains cycles
            return null;
        }
    }
    return res;
}