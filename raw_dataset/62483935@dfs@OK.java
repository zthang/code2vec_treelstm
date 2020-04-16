public void dfs(ArrayList<Integer>[] graph, int source, int[] visited, String per, int counter, long[][] cost) {
    visited[source] = 1;
    int pos = per.charAt(counter % 3) - '0';
    color[source] = pos + 1;
    this.ans += cost[pos][source];
    for (int i : graph[source]) {
        if (visited[i] == 0) {
            this.dfs(graph, i, visited, per, counter + 1, cost);
        }
    }
}