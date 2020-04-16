static void dfs(ArrayList<Integer>[] graph, int[] visited, int i) {
    for (Integer a : graph[i]) {
        if (visited[a] == 0) {
            visited[a] = 1;
            dfs(graph, visited, a);
        }
    }
}