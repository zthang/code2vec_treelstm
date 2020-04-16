public static Interval dfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
    visited[start] = true;
    int min = start, max = start;
    for (int i = 0; i < graph.get(start).size(); i++) {
        if (visited[graph.get(start).get(i)] == false) {
            Interval smallAns = dfs(graph, graph.get(start).get(i), visited);
            min = Math.min(min, smallAns.min);
            max = Math.max(max, smallAns.max);
        }
    }
    Interval ans = new Interval();
    ans.min = min;
    ans.max = max;
    return ans;
}