public static int minEdges(ArrayList<ArrayList<Integer>> graph) {
    ArrayList<Interval> intervals = new ArrayList<>();
    int V = graph.size() - 1;
    boolean[] visited = new boolean[V + 1];
    for (int i = 1; i <= V; i++) {
        if (visited[i] == false) {
            Interval interval = dfs(graph, i, visited);
            intervals.add(interval);
        }
    }
    Collections.sort(intervals);
    int ans = 0;
    for (int i = 0; i < intervals.size(); ) {
        int max = intervals.get(i).max;
        int j = i + 1;
        while (j < intervals.size() && intervals.get(j).min < max) {
            max = Math.max(max, intervals.get(j).max);
            ans++;
            j++;
        }
        i = j;
    }
    return ans;
}