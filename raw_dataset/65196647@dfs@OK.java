public static void dfs(int current, boolean[] visited, PriorityQueue<Integer> helper) {
    visited[current] = true;
    helper.add(current);
    for (Integer x : adj[current]) {
        if (!visited[x]) {
            dfs(x, visited, helper);
        }
    }
}