static void dfs(int current, int prev, int[] visited, List<Integer>[] graph, int start) {
    if (current == start && prev != -1) {
        applied = true;
        second.add(prev * 10000L + current);
    }
    if (visited[current] == 1)
        return;
    visited[current] = 1;
    for (int next : graph[current]) {
        if (second.contains(current * 10000L + next))
            continue;
        dfs(next, current, visited, graph, start);
    }
}